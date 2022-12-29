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

	public Corrida() {}


	public Corrida(Circuito circuito, int clima, List<Participante> listaParticipantes) {
		this.circuito = circuito;
		this.dnf = new HashMap<Participante,Integer>();
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
				if(!this.getDNF().containsKey(p)){
					Boolean falhou = verificaFalhaMotor(p, i+1);
					if(falhou){falhaMotor(p, i+1);}
				}
			}
		}
		for (Participante participante : dnf.keySet()) {
        	participante.setPosicao(0);
    	}
		return this.participantes;
	}



	public String printResultados() {
		Collections.sort(this.getParticipante(), new StockComparator());
		String str = "";
		for (Participante part : this.participantes){
            str += part.getPosicao() + "º: " + part.getUtilizador().getUser() + "\n"; 
        }
		return str;
	}

	

	public String DNFtoString(){
		String str = "";
		for (Map.Entry<Participante, Integer> entry : dnf.entrySet()) {
			str += "participante " + entry.getKey().getUtilizador().getUser() + ":volta " + entry.getValue();
		}
		return str;
	}

	public java.util.List<Participante> getParticipante() {
		return this.participantes;
	}


	//funcao premium que simula todo o que irá acontecer numa dada seccao
	public void verificaUltrapassagemPrem(Seccao sec) {
		int index = 0;
		for(Participante p : participantes){
			if (!this.getDNF().containsKey(p)){//se o participante ainda estiver na corrida
				Carro carro = p.getCarro();
				Piloto piloto = p.getpiloto(); 
				int posicao = p.getPosicao();
				int gdu = sec.getGDU(); //grau de dificuldade da seccao
				boolean inTime = inTime(p,index); //verifica se o utilizador está perto o suficiente para tentar a ultrapassagem
				if(gdu != 3 && posicao>1 && inTime){
					Boolean ultrapassou = tentaUltrapassagem(carro, piloto, clima, gdu);//verifica se o part foi capaz de ultrapassar o carrro a sua frente
					if(ultrapassou){
						avancaUm(p);//participante avança uma posiçao
					}else{
						verificaCrash(p);//verifica se o participante teve um crash nessa seccao
					}
				}else{//casso n seja possivel fazer a ultrapassagem verifica se o participante se despistou ou nao 
					verificaCrash(p);
				}
				index++;//index para saber a posiçao da lista ordenada de participantes 
			}
		}
	}


	//funcao nao premium que simula todo o que irá acontecer numa dada seccao muito semelhante a anterior
	public void verificarUltrapassagem(Seccao sec) {
		for(Participante p : participantes){
			if (!this.getDNF().containsKey(p))
			{	
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
		Collections.sort(this.getParticipante(), new StockComparator());
	}
	//funcao que itera por todas as seccoes de um determinado circuito determinando o que acontece em cada uma delas
	public void atualizarPosicoes() {
		ArrayList<Seccao> listaSeccoes = this.circuito.getListaSeccoes();
		if(haPremium()){//se houver um participante com premuim utiliza a funcao premium de ultrapassagem
			for(Seccao sec : listaSeccoes){
				calculaTimeDiff();//atualizar a diferenca entre 2 carros
				verificaUltrapassagemPrem(sec);
			}
		}else{//se nao utiliza a funcao default
			for(Seccao sec :listaSeccoes){
				calculaTimeDiff();//atualizar a diferenca entre 2 carros
				verificarUltrapassagem(sec);
			}
		} 
	}

	//funcao que com um conjunto de fatores verifica se o houve uma falha no motor do participante
	public Boolean verificaFalhaMotor(Participante participante, int voltas) {
		boolean falhou;
		Carro carro = participante.getCarro();
		estadoMotor estado =  carro.getEstado();
		float fiabilidade = carro.getFiabilidade();// valor calculado previamente da probabilidade do motor falhar
		switch(estado){
			case CONSERVADOR: // se o motor estiver conservador diminui a prob de falhar
				fiabilidade += 0.05;
				break;
			case AGRESSIVO:// se o motor estiver agressivo aumenta a prob de falhar
				fiabilidade -= 0.05;
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

	//funcao que coloca o participante na lista de corredores que não irao acabar a corrida
	public void falhaMotor(Participante participante, int volta) {
		dnf.put(participante, volta);
		vaiUlt(participante);
	}

	public boolean haPremium() {
		for(Participante p : this.getParticipante()){
			if (!this.getDNF().containsKey(p))
			{	
				if (p.getUtilizador() instanceof Jogador){
					Jogador j = (Jogador) p.getUtilizador();
					if(j.getIsPremium()){
						return true;
					}
				} 
			}
		}
		return false;
	}


	public void avancaUm(Participante participante) {
		int indexInFront = participante.getPosicao()-2;
		Participante inFront = this.participantes.get(indexInFront);
		inFront.setPosicao(indexInFront+2);//mudar a posicao do part ha frente para a pos atual do jogador
		participante.setPosicao(indexInFront+1);
		//Collections.sort(this.getParticipante(), new StockComparator());
	}


	public void vaiUlt(Participante participante) {
		int posAtual = participante.getPosicao();
		int lastPos = this.getParticipante().size();
		participante.setPosicao(lastPos); 
		for(Participante p : this.getParticipante()){
			if (!this.getDNF().containsKey(p))
			{	
				int posicao = p.getPosicao();
				if(!(p.equals(participante)) && posicao<posAtual)
					p.setPosicao(posicao++);
			}
		}
		//Collections.sort(this.getParticipante(), new StockComparator());
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
			Participante p = this.participantes.get(i);
			if(!this.getDNF().containsKey(p)){
				float inFront = this.participantes.get(i-1).getTimeDiff();
				this.participantes.get(i).setTimeDiff(inFront+(time*10));
			}
				
			
		}
	}

	public boolean inTime(Participante participante, int index){
		//calcula a diferenca de tempos entre o participante e o carro a sua frente
		float timeDiff = participante.getTimeDiff() - this.participantes.get(index-1).getTimeDiff();
		if(timeDiff>2)
			return false;
		else{
			Carro carro = participante.getCarro();
			String classeCarro = carro.getClass().getSimpleName();//classe do carro do participante
			Carro carroInFront = this.participantes.get(index).getCarro();
			String classInFront = carroInFront.getClass().getSimpleName();//classe do carro na posiçao em frente
			//dependendo da classe verifica se existe possibilidade de ultrapassar ou nao
			return classDif(classeCarro, classInFront, timeDiff);
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

	public boolean classDif(String classeCarro, String classInFront, float timeDiff){
		if(classeCarro.equals(classInFront)){
			if(timeDiff<1)
				return true;
			else
				return false;
		}
		switch(classeCarro){
			case("C1H"):
				if(timeDiff<2)
					return true;
				else 
					return false;
			case("C1"):
				if(classInFront.equals("C1H")){
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
			case("C2H"):
				if(classInFront.equals("C1H") || classInFront.equals("C1") ){
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
			case("C2"):
				if(classInFront.equals("C1H") || classInFront.equals("C1") || classInFront.equals("C2H")){
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
			case("GTH"):
				if(classInFront.equals("GT") || classInFront.equals("SC")){
					if(timeDiff<2)
						return true;
					else 
						return false;
				}else{
					if(timeDiff<0.5f)
						return true;
					else 
						return false;
				}
			case("GT"):
				if(classInFront.equals("SC")){
					if(timeDiff<2)
						return true;
					else 
						return false;
				}else{
					if(timeDiff<0.5f)
						return true;
					else 
						return false;
				}
			case("SC"):
				if(timeDiff<0.5f)
					return true;
				else 
					return false;
			default:
				return false;
		}
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