package businesslayer.Corrida;
import java.io.*;
import java.util.*;
import java.util.Random;
import businesslayer.Carro.Carro;
import businesslayer.Carro.tipoPneu;
import businesslayer.Corrida.*;

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

	/**
	 * 
	 * @param l
	 * @param c
	 * @param r
	 * @param p
	 * @param clima
	 * @param lp
	 */
	public Corrida(Circuito circuito, int clima, List<Participante> listaParticipantes) {
		this.circuito = circuito;
		this.dnf = Collections.emptyMap();
		this.clima = clima;
		this.participantes = listaParticipantes;
		this.Tempos = 0;
	}

	/**
	 * 
	 * @param c
	 */
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

	/**
	 * Metodos
	 */
	public Corrida clone() {
		// TODO - implement Corrida.clone
		throw new UnsupportedOperationException();
	}

	/**
	 * Simula a corrida
	 */
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

	/**
	 * Lista os resultados da corrida.
	 */
	public String printResultados() {
		// TODO - implement Corrida.printResultados
		throw new UnsupportedOperationException();
	}

	/**
	 * Lista de Acidentados DNF
	 */
	public String printDNF() {
		// TODO - implement Corrida.printDNF
		throw new UnsupportedOperationException();
	}

	public java.util.List<Participante> getParticipante() {
		// TODO - implement Corrida.getParticipante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 * @param sec
	 */
	public void verificaUltrapassagemPrem(List<Participante> l, Seccao sec) {
		for(Participante p : participantes){
			Carro carro = p.getCarro();
			Piloto piloto = p.getpiloto(); 
			int posicao = p.getPosicao();
			int gdu = sec.getGDU();
			boolean inTime = getTimeDiff(p);
			if(gdu != 3 && posicao>1 && inTime){
				Boolean tenta = tentaUltrapassagem(carro, piloto, clima, gdu);
				if(tenta){
					avancaUm(l, p);
				}else{
					verificaCrash(p);
				}
			}else{
				verificaCrash(p);
			}
		}
	}

	/**
	 * 
	 * @param l
	 * @param sec
	 */
	public void verificarUltrapassagem(List<Participante> l, Seccao sec) {
		for(Participante p : participantes){
			Carro carro = p.getCarro();
			Piloto piloto = p.getpiloto(); 
			int posicao = p.getPosicao();
			int gdu = sec.getGDU();
			if(gdu != 3 && posicao>1){
				Boolean tenta = tentaUltrapassagem(carro, piloto, clima, gdu);
				if(tenta){
					avancaUm(l, p);
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
			verificaUltrapassagemPrem(participantes, sec);
			}
		}else{
			for(Seccao sec :listaSeccoes){
				verificarUltrapassagem(participantes, sec);
			}
		} 
	}

	/**
	 * 
	 * @param voltas
	 */
	public Boolean verificaFalhaMotor(Participante participante, int voltas) {
		// TODO - implement Corrida.verificaFalhaMotor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param participante
	 * @param volta
	 */
	public void falhaMotor(Participante participante, int volta) {
		// TODO - implement Corrida.falhaMotor
		throw new UnsupportedOperationException();
	}

	public boolean haPremium() {
		// TODO - implement Corrida.haPremium
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaParticipante
	 * @param participante
	 */
	public void avancaUm(List<Participante> listaParticipante, Participante participante) {
		// TODO - implement Corrida.avancaUm
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaParticipante
	 * @param participante
	 */
	public void vaiUlt(List<Participante> listaParticipante, Participante participante) {
		// TODO - implement Corrida.vaiUlt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param agrPiloto
	 * @param pneus
	 * @param clima
	 * @param vsPiloto
	 */
	public boolean calculaCrash(float agrPiloto, tipoPneu pneus, int clima, float vsPiloto, int volta){
		Random rand = new Random();
		float limite = rand.nextInt(100);
		float prob = 100*(volta*agrPiloto*clima*vsPiloto);
		return limite>prob;
	}

	/**
	 * 
	 * @param estadoMotor
	 * @param fiabCarro
	 * @param cilindCarro
	 * @param voltas
	 */
	public boolean calculaFalha(Estado estadoMotor, float fiabCarro, int cilindCarro, int voltas) {
		// TODO - implement Corrida.calculaFalha
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param participante
	 */
	public boolean getTimeDiff(Participante participante) {
		// TODO - implement Corrida.getTimeDiff
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param carro
	 * @param piloto
	 * @param clima
	 * @param gdu
	 */
	public boolean tentaUltrapassagem(Carro carro, Piloto piloto, int clima, int gdu) {
		// TODO - implement Corrida.tentaUltrapassagem
		throw new UnsupportedOperationException();
	}

	public boolean verificaCrash(Participante p){
		float agressividade = p.getpiloto().getAgressividade();
		float vs = p.getpiloto().getChuvaVSseco();
		tipoPneu pneus = p.getCarro().getPneus();
		if(calculaCrash(agressividade, pneus, clima, vs, volta)){
			vaiUlt(participantes, p);
		}
		return true;
	}

}