package Utilizador;

import java.util.HashMap;

public class FacadeUtilizador implements IFacadeUtilizador {

	private HashMap<String,Administrador> mapAdmins = new HashMap<String,Administrador>();
	private HashMap<String,Jogador> mapJogadores = new HashMap<String,Jogador>();
	private HashMap<Integer,Convidado> mapConvidados = new HashMap<Integer,Convidado>();

	public HashMap<String,Administrador> getMapAdmins()
	{
		return this.mapAdmins;
	}
	public HashMap<String,Jogador> getMapJogador()
	{
		return this.mapJogadores;
	}
	public HashMap<Integer,Convidado> getMapCondidados()
	{
		return this.mapConvidados;
	}
	
	public boolean Login(String username, String password) throws UtilizadorInvalido
	{
		if(!this.getMapAdmins().containsKey(username) || !this.getMapJogador().containsKey(username))
			throw new UtilizadorInvalido("Username nao existe, por favor registe-se.");
		else
		{
			if(this.getMapJogador().containsKey(username))
			{
				String pw = this.getMapJogador().get(username).getPassword();
				return (pw.equals(password) ? true : false);
			}
			else
			{
				String pw = this.getMapAdmins().get(username).getPassword();
				return (pw.equals(password) ? true : false);
			}
		}
	}


	//
	public boolean Registo(String username, String password, boolean isPremium)
	{
			return true;
	}

	//funcao que usamos para adicionar os admins (hard coded), os users 
	//nao devem ter acesso a esta funcao
	public void RegistoAdmin(String username, String password) throws UtilizadorInvalido
	{
		if(this.getMapAdmins().containsKey(username))
			throw new UtilizadorInvalido("Erro no registo, user já existe");
		else
			this.getMapAdmins().put(username, new Administrador(username,password));

	}

}