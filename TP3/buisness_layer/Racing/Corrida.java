package Racing;
import java.io.*;
import java.util.*;
import java.util.Random;
import Racing.*;
import Carro.*;
import Utilizador.*;

public class Corrida implements Serializable {

	private Circuito circuito;
	private Map<Participante, Integer> dnf;
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

	public java.util.Map<Participante, Integer> getDNF() {
		return this.dnf;
	}



	public Corrida clone() {
		return new Corrida(this);
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
		Collections.sort(this.getParticipante(), new StockComparator());
		String str = "";
		for (Participante part : this.participantes) {
            str += part.getPosicao() + "º: " + part.getUtilizador().getUser() + "\n"; 
        }
		return str;
	}

	

	public String printDNF() {
		String str = "";
		for (Map.Entry<Participante, Integer> entry : dnf.entrySet()) {
			str += "participante " + entry.getKey().getUtilizador().getUser() + ":volta " + entry.getValue();
		}
		return str;
	}

	public java.util.List<Participante> getParticipante() {
		return this.participantes;
	}



	public void verificaUltrapassagemPrem(Seccao sec) {
		int index = 0;
		for(Participante p : participantes){
			Carro carro = p.getCarro();
			Piloto piloto = p.getpiloto(); 
			int posicao = p.getPosicao();
			int gdu = sec.getGDU();
			boolean inTime = inTime(p,index);
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
			index++;
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
				calculaTimeDiff();//atualizar a diferenca entre 2 carros
				verificaUltrapassagemPrem(sec);
			}
		}else{
			for(Seccao sec :listaSeccoes){
				calculaTimeDiff();//atualizar a diferenca entre 2 carros
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
		float prob = rand.nextFloat();
		if(prob > fiabilidade)
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
		float limite = rand.nextFloat();
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

	public void calculaTimeDiff() {
		Collections.sort(this.getParticipante(), new StockComparator());
		int size = this.participantes.size();
		Random random = new Random();
		float time = random.nextFloat();
		this.participantes.get(0).setTimeDiff(0);
		for(int i = 1; i<size;i++){
			float inFront = this.participantes.get(i-1).getTimeDiff();
			this.participantes.get(i).setTimeDiff(inFront+(time*10));
		}
	}

	public boolean inTime(Participante participante, int index){
		//calcula a diferenca de tempos entre o participante e o carro a sua frente
		float timeDiff = participante.getTimeDiff() - this.participantes.get(index-1).getTimeDiff();
		if(timeDiff>2)
			return false;
		else{
			Carro carro = participante.getCarro();
			String classeCarro = carro.getClass().getSimpleName();
			Carro carroInFront = this.participantes.get(index).getCarro();
			String classInFront = carroInFront.getClass().getSimpleName();
			switch(classeCarro){
				case("C1H"):
					if(timeDiff<2)
						return true;
					else 
						return false;
				case("C1"):
					
			}
			if(classeCarro.equals(classInFront)){
				if(timeDiff<1)
					return true;
				else 
					return false;
			}
			if(classeCarro.equals("C1") || classeCarro.equals("C1H")){
				
			}else if(classeCarro.equals("C2") || classeCarro.equals("C2H")){
				if(carroInFront.equals("C1") || carroInFront.equals("C1H")){
					if(timeDiff<0.5f)
						return true;
					else	
						return false;
				}else{
					if(timeDiff<2)
						return true;
					else	
						return false;
				}
			}else if(classeCarro.equals("GT") || classeCarro.equals("GTH")){
				if(carroInFront.equals("C1") || carroInFront.equals("C1H")){
					if(timeDiff<0.5f)
						return true;
					else	
						return false;
				}else{
					if(timeDiff<2)
						return true;
					else	
						return false;
				}
			}else if(classeCarro.equals("SC")){

			}
		}
		

	}


	public boolean tentaUltrapassagem(Carro carro, Piloto piloto, int clima, int gdu) {
		float probInicial = 1;
		estadoMotor estado = carro.getEstado();
		float agressividade = piloto.getAgressividade();
		Random random = new Random();
		float limite = random.nextFloat();
		if (clima == 1)// caso esteja a chover prob de ultrapassar diminui
			probInicial -= 0.05;
		if(gdu == 5){//caso o GDU seja dificiil
			probInicial -=0.1;
		}
		probInicial += -0.05 + (0.1*agressividade);
		switch(estado){
			case CONSERVADOR:
				probInicial -= 0.05;
				break;
			case AGRESSIVO:
				probInicial += 0.05;
				break;
			default:
				break;
		}
		if(limite>probInicial)
			return true;
		else
			return false;
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

	class StockComparator implements Comparator<Participante> {
		@Override
		public int compare(Participante p1, Participante p2)
		{
			if (p1.getPosicao() == p2.getPosicao())
			return 0;
			else if (p1.getPosicao() > p2.getPosicao())
			return 1;
			else
			return -1;
		}
	}

}