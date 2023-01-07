package buisness;

import java.util.*;
import buisness.Carro.*;
import buisness.Racing.*;
import buisness.Utilizador.*;

public class RacingSimFacade implements IRacingSimFacade {
	//carros
	private FacadeCarro fCarro = new FacadeCarro();
	//corrida
	private FacadeCorrida fCorrida = new FacadeCorrida();
	//utilizador 
	private FacadeUtilizador fUtilizador = new FacadeUtilizador();
	private Utilizador you = null;


	@Override
	public void corrida() {
		// TODO Auto-generated method stub
		
	}

	public String addCircuito(String nome, int dist, int voltas, int n_retas, int n_chicanes){
		if (fCorrida.getMapCircuitos().containsKey(nome)) return "Failure";
		Circuito circ = new Circuito(); //criar objeto
		circ.createCircuito(nome, dist, voltas, n_retas, n_chicanes); //atribuir parametros
		fCorrida.getMapCircuitos().put(nome, circ);
		return "Success";
	}

	public String addCampeonato(ArrayList<String> circuitos, String nomeProva){
		ArrayList<Circuito> listaCircuitos = new ArrayList<>();
		for(String nome : circuitos){
			Circuito c = fCorrida.getMapCircuitos().get(nome);
			if(c!=null)
				listaCircuitos.add(c);
		}  
		return ( (fCorrida.insertCampeonato(listaCircuitos, nomeProva)) ? "Sucess" : "Failure");
	}

	//C1
		//c1 -> marca,modelo,potencia,cilindrada,pa
		//c1h -> marca,modelo,potencia,cilindarda,pa,potenciaE
		//c2 -> marca,modelo,potencia,cilindrada,pa,afinacao
		//c2h->marca,modelo,potencia,cilindrada,pa,afinacao,potenciaE
		//gt->marca,modelo,potencia,cilindrada,pa
		//gth->marca,modelo,potencia,cilindrada,pa,potenciaE
		//sc->marca,modelo,potencia,cilindrada,pa

	//Hibridos				 //1 -> 3  
		public String addCarrohibridro(int tipo, String marca, String modelo,int cilindrada, int potencia, float pa, int potenciaE) {
			boolean deuCerto = false;
			try
			{
				switch (tipo)
				{
					case 1:
						C1H c1 = new C1H(marca,modelo,cilindrada,potencia,pa,potenciaE);
						deuCerto = ( (fCarro.addCarro(c1)) ?  true :  false);
						break;
					case 2:
						C2H c2 = new C2H(marca,modelo,cilindrada,potencia,pa,potenciaE);
						deuCerto = ( (fCarro.addCarro(c2)) ?  true :  false);
						break;
					case 3:
						GTH gt = new GTH(marca,modelo,cilindrada,potencia,pa,potenciaE);
						deuCerto = ( (fCarro.addCarro(gt)) ?  true :  false);
						break;
					default:
						break;		
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return (deuCerto ? "Success" : "Failure");

	}
	//Nao hibridos				//1->4 
		public String addCarro(int tipo, String marca, String modelo, int cilindrada, int potencia, float pa) {
				boolean deuCerto = false;
			try
			{
				switch (tipo)
				{
					case 1:
						C1 c1 = new C1(marca,modelo,cilindrada,potencia,pa);
						deuCerto = ( (fCarro.addCarro(c1)) ?  true :  false);
						break;
					case 2:
						C2 c2 = new C2(marca,modelo,cilindrada,potencia,pa);
						deuCerto = ( (fCarro.addCarro(c2)) ?  true :  false);
						break;
					case 3:
						GT gt = new GT(marca,modelo,cilindrada,potencia,pa);
						deuCerto = ( (fCarro.addCarro(gt)) ?  true :  false);
						break;
					case 4:
						SC sc = new SC(marca,modelo,cilindrada,potencia,pa);
						deuCerto = ( (fCarro.addCarro(sc)) ?  true :  false);
						break;
					default:
						break;		
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return (deuCerto ? "Success" : "Failure");
	}




	@Override
	public void addPiloto(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCampeonato(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCircuito(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCarro(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPiloto(Scanner sc) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delCircuito(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCampeonato(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCarro(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delPiloto(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public boolean existeCampeonato(String nomeCampeonato){
		return fCorrida.getMapCampeonatos().containsKey(nomeCampeonato);
	}
	
	public boolean existeCircuito(String nomeCircuito){
		return fCorrida.getMapCircuitos().containsKey(nomeCircuito);
	}

	public boolean existePiloto(String nomePiloto){
		return fCorrida.getMapPilotos().containsKey(nomePiloto);
	}

	public boolean existeCarro(String modelo){
		boolean res = false;
		try{
			if(!(fCarro.findCarro(modelo) == null))
				res = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}

	


	//um utilizador utiliza uma "template" que ja esta no sistema(e que foi adicionada pelo administrador) para criar um lobby
	public void criarLobby(Campeonato campeonato){
		int num_lobby = fCorrida.getMapLobbys().size();
		fCorrida.getMapLobbys().put((num_lobby+1), campeonato);
	}

	//entrar no lobby de um user para 
	public boolean joinLobby(Scanner sc)
	{
		if(you == null || this.getClass().getSimpleName().equals("Administrador")) return false;// sem login/registo ou é admin

		System.out.println("Número do lobby:"); 
		int num_lobby = sc.nextInt(); 
		
		if(!fCorrida.getMapLobbys().containsKey(num_lobby)) //lobby nao existe
			return false;
		
		Carro c = null;

		Piloto p = null;
		//mostrar o campeonato em que entrou
		System.out.println(fCorrida.getMapLobbys().get(num_lobby).toString());
		System.out.println("Prima qualquer botao para selecionar um carro.");
		sc.next();
		//estas duas linhas vao ser uma funcao do UI
		System.out.println(fCarro.garagemToString());
		System.out.println("Digite o carro que quer usar (Modelo)");
		//
		try 
		{
			while( (c = fCarro.findCarro(sc.nextLine())) != null)
				c = fCarro.findCarro(sc.nextLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		//UI
		System.out.println(fCorrida.listaPilotosStr());
		System.out.println("Digite o piloto que quer usar(Nome do Piloto");
		//
		while( (p = fCorrida.findPiloto(sc.nextLine())) != null )
			p = fCorrida.findPiloto(sc.nextLine());
		//customizacao do carro
		
		String tipo_carro = c.getClass().getSimpleName();

		//funcoes para o UI//
		System.out.println("Mudar downforce?(0.00 - 1.00 || VALOR DEFAULT -> 0.50)");
		float df = sc.nextFloat();

		c.setDownforce(df);

		System.out.println("Escolha tipo de pneus(duro/macio/chuva)");
		tipoPneu pneu = tipoPneu.fromString(sc.nextLine());
		c.setPneus(pneu); 

		System.out.println("Escolha tipo de pneus(conservador/normal/agressivo)");
		estadoMotor estado = estadoMotor.fromString(sc.nextLine());
		c.setEstado(estado);

		//criar participante
		Participante participante = null;

		if(tipo_carro.equals("C2"))
		{
			
			System.out.println("Mudar afinacao?(0.00 - 1.00 || VALOR DEFAULT -> 0.50)");
			float afinacao = sc.nextFloat();
			C2 c2 = (C2)c;
			c2.setAfinacao(afinacao);
			participante = new Participante(you,p,c2);
			
		}
		else
		{
			participante = new Participante(you,p,c);
		}
		
		fCorrida.getMapLobbys().get(num_lobby).addParticipante(participante);
		
		return true;
	}

	@Override
	public void addCircuito(Scanner sc) {
		// TODO Auto-generated method stub
		
	}


}