package Utilizador;

import java.util.HashMap;

public class FacadeUtilizador implements IFacadeUtilizador {

	private HashMap<String,Administrador> mapAdmins = new HashMap<String,Administrador>(); //chave -> username
	private HashMap<String,Jogador> mapJogadores = new HashMap<String,Jogador>(); //chave -> username
	private HashMap<String,Convidado> mapConvidados = new HashMap<String,Convidado>(); //chave -> ("Convidado " + nº)

	public HashMap<String,Administrador> getMapAdmins()
	{
		return this.mapAdmins;
	}
	public HashMap<String,Jogador> getMapJogador()
	{
		return this.mapJogadores;
	}
	public HashMap<String,Convidado> getMapConvidados()
	{
		return this.mapConvidados;
	}

	//login devolve um utilizador(jogador/admin) a partir de um par username/password.
	//NULL -> email e password nao condizem
	//excecao -> username nao existe
	//Utilizador -> sucesso
	public Utilizador Login(String username, String password) throws UtilizadorInvalido
	{
		if(!this.getMapAdmins().containsKey(username) || !this.getMapJogador().containsKey(username))
			throw new UtilizadorInvalido("Username nao existe, por favor registe-se.");
		else if(password.length()<8)
			throw new UtilizadorInvalido("Password demasiado curta.");
		else
		{
			if(this.getMapJogador().containsKey(username))
			{
				String pw = this.getMapJogador().get(username).getPassword();
				return (pw.equals(password) ? this.getMapJogador().get(username).clone() : null);
			}
			else
			{
				String pw = this.getMapAdmins().get(username).getPassword();
				return (pw.equals(password) ? this.getMapAdmins().get(username) : null);
			}
		}
	}

	//login como convidado resulta sempre.
	public Convidado LoginConvidado()
	{
		String nome_convidado = "Convidado " + (this.getMapConvidados().size()+1);
		Convidado c = new Convidado (nome_convidado);
		this.getMapConvidados().put(nome_convidado, new Convidado (nome_convidado));
		return c;
	}

	//se nao acontece nada o registo teve sucesso. Se ocorreu a excecao, registo falhou.
	public void Registo(String username, String password, boolean isPremium) throws UtilizadorInvalido
	{
		if (this.getMapJogador().containsKey(username))
			throw new UtilizadorInvalido("Username já existe.");
		if(password.length() < 8)
			throw new UtilizadorInvalido("Password demasiado curta.");
		this.getMapJogador().put(username, new Jogador(username, password, 0, isPremium));
		return;
		
	}

	//funcao que usamos para adicionar os admins (hard coded), os utilizadores normais 
	//nao devem ter acesso a esta funcao
	public void RegistoAdmin(String username, String password) throws UtilizadorInvalido
	{
		if(this.getMapAdmins().containsKey(username))
			throw new UtilizadorInvalido("Erro no registo, user já existe");
		else if(password.length() < 8)
			throw new UtilizadorInvalido("Password demasiado curta");
		else
			this.getMapAdmins().put(username, new Administrador(username,password));

	}

	//funcoes que cada user tem

	public void criarLobby(Campeonato campeonato){
	int num_lobby = mapLobbys.size();
		
	}
	
	public boolean joinLobby(int num_lobby)
	{
		if(!mapLobbys.containsKey(num_lobby))
			return false;
		mapLobbys.get(num_lobby)
			
	}

}