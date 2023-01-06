import java.util.*;
import Racing.*;
import Utilizador.*;
import Carro.*;

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

	@Override
	public void addCircuito(Scanner sc) {
		String nome = sc.nextLine();
		int distancia = sc.nextInt();
		int voltas = sc.nextInt();
		int retas = sc.nextInt();
		int chicanas = sc.nextInt();
		
	}
	@Override
	public boolean addCampeonato(Scanner sc) {
		ArrayList<Circuito> listaCircuitos = new ArrayList<>();
		String prova = sc.nextLine();
		String numCircuito = sc.nextLine();
		while(!(numCircuito.equals("F"))){
			Circuito circuito = fCorrida.getMapCircuitos().get(numCircuito);
			listaCircuitos.add(circuito);
		}
		if(fCorrida.addCampeonato(listaCircuitos, prova))
			System.out.println("Campeonato criado com sucesso");
		else
			System.out.println("Campeonato já foi criado, altere o nome");
		
	}

	@Override
	public void addCarro(Scanner sc) {
		// TODO Auto-generated method stub
		
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
	public void delCampeonato(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCircuito(Scanner sc) {
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

	public boolean addCampeonato(ArrayList<Circuito> listaCircuitos, String nomeProva){
		return fCorrida.addCampeonato(listaCircuitos, nomeProva);
	}

	public void criarLobby(Campeonato campeonato){
		int num_lobby = fCorrida.getMapLobbys().size();
		fCorrida.getMapLobbys().put((num_lobby+1), campeonato);
	}

		public boolean joinLobby(Scanner sc)
	{
		if(you == null || this.getClass().getSimpleName().equals("Administrador")) return false;// sem login/registo ou é admin

		System.out.println("Número do lobby:"); 
		
		String nomeJogador = you.getUser();
		int num_lobby = sc.nextInt(); 
		if(!fCorrida.getMapLobbys().containsKey(num_lobby)) //lobby nao existe
			return false;
		
		Carro c = null;

		Piloto p = null;
		String modelo_piloto;
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
		
		participante.customizarCarro();
		
		//estas duas linhas vao para uma funcao do UI
		System.out.println(fCorrida.listaPilotosStr());
		System.out.println("Digite o piloto que quer usar(Nome do Piloto");
		//
		while( (p = fCorrida.findPiloto(sc.nextLine())) != null )
			p = fCorrida.findPiloto(sc.nextLine());

		Participante participante = new Participante(you,p,c);

		
		

		return true;
	}

}