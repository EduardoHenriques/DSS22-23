package Racing;
import java.io.*;
import java.util.*;
import java.util.Random;
import Racing.*;
import Carro.*;
import Utilizador.*;

public class Corrida implements Serializable {

	private Circuito circuito;
	private java.util.Map<Participante, Integer> dnf;
	private int clima;
	private float Tempos;
	private List<Participante> participantes;
	private int volta = 0;
	
	public int getClima() {
		return this.clima;
	}

	/**
	 * 1-chove 0-sol
	 * 
	 * Construtores
	 */
	public Corrida() {}


	public Corrida(Circuito circuito, int clima, List<Participante> listaParticipantes) {
		this.circuito = circuito;
		this.dnf = Collections.emptyMap();
		this.clima = clima;
		this.participantes = listaParticipantes;
		this.Tempos = 0;
	}



	public Corrida(Corrida corrida) {
		this.circuito = corrida.circuito;
		this.dnf = corrida.dnf;
		this.Tempos = corrida.Tempos;
		this.clima = corrida.clima;
		this.participantes = corrida.participantes;
		this.volta = corrida.volta;
	}

	public java.util.Map<Carro, Integer> getDNF() {
		// TODO - implement Corrida.getDNF
		throw new UnsupportedOperationException();
	}



	public Corrida clone() {
		// TODO - implement Corrida.clone
		throw new UnsupportedOperationException();
	}


	public List<Participante>  simulaCorrida() {
		int num_voltas = circuito.getVoltas();
		for(int i = 0; i<num_voltas;i++){
			atualizarPosicoes();
			for(Participante p : this.participantes){
				Boolean falhou = verificaFalhaMotor(p, i+1);
				if(falhou){falhaMotor(p, i+1);}
			}
		}
		return this.participantes;
	}



	public String printResultados() {
		// TODO - implement Corrida.printResultados
		throw new UnsupportedOperationException();
	}

	

	public String printDNF() {
		// TODO - implement Corrida.printDNF
		throw new UnsupportedOperationException();
	}

	public java.util.List<Participante> getParticipante() {
		// TODO - implement Corrida.getParticipante
		throw new UnsupportedOperationException();
	}



	public void verificaUltrapassagemPrem(Seccao sec) {
		for(Participante p : participantes){
			Carro carro = p.getCarro();
			Piloto piloto = p.getpiloto(); 
			int posicao = p.getPosicao();
			int gdu = sec.getGDU();
			boolean inTime = getTimeDiff(p);
			if(gdu != 3 && posicao>1 && inTime){
				Boolean tenta = tentaUltrapassagem(carro, piloto, clima, gdu);
				if(tenta){
					avancaUm(p);
				}else{
					verificaCrash(p);
				}
			}else{
				verificaCrash(p);
			}
		}
	}



	public void verificarUltrapassagem(Seccao sec) {
		for(Participante p : participantes){
			Carro carro = p.getCarro();
			Piloto piloto = p.getpiloto(); 
			int posicao = p.getPosicao();
			int gdu = sec.getGDU();
			if(gdu != 3 && posicao>1){
				Boolean tenta = tentaUltrapassagem(carro, piloto, clima, gdu);
				if(tenta){
					avancaUm(p);
				}else{
					verificaCrash(p);
				}
			}else{
				verificaCrash(p);
			}
		}
	}

	public void atualizarPosicoes() {
		ArrayList<Seccao> listaSeccoes = this.circuito.getListaSeccoes();
		if(haPremium()){
			for(Seccao sec : listaSeccoes){
			verificaUltrapassagemPrem(sec);
			}
		}else{
			for(Seccao sec :listaSeccoes){
				verificarUltrapassagem(sec);
			}
		} 
	}


	public Boolean verificaFalhaMotor(Participante participante, int voltas) {
		boolean falhou;
		Carro carro = participante.getCarro();
		estadoMotor estado =  carro.getEstado();
		float fiabilidade = carro.getFiabilidade();
		switch(estado){
			case CONSERVADOR:
				fiabilidade -= 0.05;
				break;
			case AGRESSIVO:
				fiabilidade += 0.05;
				break;
			default:
				break;
		}
		Random rand = new Random();
		float prob = rand.nextFloat(100);
		if(prob > fiabilidade*100)
			falhou = true;
		else
			falhou = false;
		return falhou;
	}


	public void falhaMotor(Participante participante, int volta) {
		throw new UnsupportedOperationException();
	}

	public boolean haPremium() {
		for(Participante p : this.getParticipante()){
			if (p.getUtilizador() instanceof Jogador){
				Jogador j = (Jogador) p.getUtilizador();
				if(j.getIsPremium()){
					return true;
				}
			} 
		}
		return false;
	}


	public void avancaUm(Participante participante) {
		int posAtual = participante.getPosicao()+1;
		for(Participante p : this.getParticipante()){
			if(!p.equals(participante) && posAtual == p.getPosicao())
				p.setPosicao(posAtual--);
		}
	}


	public void vaiUlt(Participante participante) {
		int posAtual = participante.getPosicao();
		int lastPos = this.getParticipante().size();
		participante.setPosicao(lastPos); 
		for(Participante p : this.getParticipante()){
			int posicao = p.getPosicao();
			if(!(p.equals(participante)) && posicao<posAtual){
				p.setPosicao(posicao++);
			}
		}

	}



	public boolean calculaCrash(float agrPiloto, tipoPneu pneus, int clima, float vsPiloto, int volta){
		Random rand = new Random();
		float limite = rand.nextFloat(100);
		float probPneus = probPneus(pneus, clima, volta);
		float probClima = probClima(pneus, clima, vsPiloto);
		float prob = (probPneus*probClima);
		prob += 0.05 + (-0.1*agrPiloto);
		return(limite>prob);
	}

	public float probPneus(tipoPneu pneus, int clima, int volta){
		float probInicial = 1;
		switch(pneus){
			case MACIO:
				probInicial -= (0.0033*volta);
				break;
			case DURO:
				probInicial -= (0.0025*volta);
				break;
			case CHUVA:
				if(clima == 1) //caso esteja a chuver
					probInicial -= (0.0028*volta);	
				else // caso esteja sol, penaliza de forma severa o jogador.
					probInicial -= (0.025*volta); 
				break;
			default:
				probInicial -= (0.003*volta);
				break;
		}
		return probInicial;
	}

	public float probClima(tipoPneu pneus, int clima, float vsPiloto){
		float probInicial = 1;
		switch(pneus){
			case MACIO:
				if(clima == 1)
					probInicial -= 0.25;
			case DURO:
				if(clima ==1)
					probInicial -= 0.20;
			case CHUVA:
				if(clima == 1) //caso esteja a chuver
					probInicial -= 0;	
				else // caso esteja sol, penaliza de forma severa o jogador.
					probInicial -= 0.40; 
			default:
				probInicial -= 0.10;
			}
		if(clima == 0)
			probInicial += -0.05 + (0.1*vsPiloto);
		else
			probInicial += 0.05 + (-0.1*vsPiloto);
		return probInicial;
	}

	
	public boolean calculaFalha(estadoMotor motor, float fiabCarro) {
		// TODO - implement Corrida.calculaFalha
		throw new UnsupportedOperationException();
	}


	public boolean getTimeDiff(Participante participante) {
		// TODO - implement Corrida.getTimeDiff
		throw new UnsupportedOperationException();
	}


	public boolean tentaUltrapassagem(Carro carro, Piloto piloto, int clima, int gdu) {
		// TODO - implement Corrida.tentaUltrapassagem
		throw new UnsupportedOperationException();
	}

	public boolean verificaCrash(Participante p){
		float agressividade = p.getpiloto().getAgressividade();
		float vs = p.getpiloto().getChuvaVSseco();
		tipoPneu pneus = p.getCarro().getPneus();
		if(calculaCrash(agressividade, pneus, clima, vs, volta)){
			vaiUlt(p);
		}
		return true;
	}

}