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
	public void addCampeonato(Scanner sc) {
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

		System.out.println("Número do lobby:"); //para tirar depois
		
		String nomeJogador = you.getUser();
		int num_lobby = sc.nextInt(); 
		if(!fCorrida.getMapLobbys().containsKey(num_lobby)) //lobby nao existe
			return false;
		
		Carro c = null;
		String modelo_carro;

		Piloto p = null;
		String modelo_piloto;
		
		
		while(true)
		{
		System.out.println("1->Ver Carros || \n2-> Selecionar Carro(pelo modelo) ||");
		int optCar = sc.nextInt();
		if(optCar==1) System.out.println(fCarro.garagemToString());
		if(optCarro==2)	
		}
		

		fCorrida.getMapLobbys().get(num_lobby).getListaPart().put(u.getUser(),u);
		return true;
	}

}