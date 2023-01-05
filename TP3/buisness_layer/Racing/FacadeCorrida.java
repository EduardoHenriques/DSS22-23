package Racing;

import java.util.*;

public class FacadeCorrida implements IFacadeCorrida {

	private HashMap <String,Campeonato> mapCampeonatos = new HashMap<String,Campeonato>();
	private HashMap <Integer,Campeonato> mapLobbys = new HashMap<Integer,Campeonato>();
	private HashMap <String,Piloto> mapPilotos = new HashMap<String,Piloto>();
	private HashMap <String,Participante> mapParticipantes = new HashMap<String,Participante>();
	private HashMap <String,Circuito> mapCircuitos = new HashMap<String,Circuito>();
	private HashMap <String,Seccao> mapSeccoes = new HashMap<String,Seccao>();

	public String resultadosCorrida() {
		return null;
	}
	public String listaCircuitos() {
		return null;
	}
	public String listaParticipantes() {
		return null;
	}

	public HashMap<String,Campeonato> getMapCampeonatos()
	{
		return this.mapCampeonatos;
	}
	
	public HashMap<Integer,Campeonato> getMapLobbys()
	{
		return this.mapLobbys;
	}

	public HashMap<String,Piloto> getMapPilotos()
	{
		return this.mapPilotos;
	}
	
	HashMap <String,Participante> getMapParticipantes(){
		return this.mapParticipantes;
	} 
	
	public HashMap <String,Seccao> getMapSeccoes(){
		return this.mapSeccoes;
	}

	public HashMap <String,Circuito> getMapCircuitos(){
		return this.mapCircuitos;
	}
	
	
	//funcao exclusiva do admin
	public boolean addCampeonato(ArrayList<Circuito> listaCircuitos, String nomeProva){
		if(this.mapCampeonatos.containsKey(nomeProva))
			return false;// incapaz de criar um novo campeonato pois este já existe
		else{
			Campeonato campeonato = new Campeonato(listaCircuitos, nomeProva);
			this.mapCampeonatos.put(nomeProva, campeonato);
			return true;// campeonato criado com sucesso
		}
	}
	
	public boolean addCircuito(String nome, int dist, int voltas, int n_retas, int n_chicanes){
		Circuito circuito = create
	} 

	public void startCampeonato(Campeonato c)
	{
		ArrayList<Participante> participantes = new ArrayList<>(c.getListaPart().values());
		for(Circuito circ : c.getCircuitos())
		{
			Corrida corr = new Corrida(circ.clone(),(int)Math.round(Math.random()),participantes);
			c.getCorridas().put(corr,false);
		}
		//simulacao
		System.out.println(simularProximaCorrida(c.getProva()));
		//reset ao campeonato
		c.setListaPart(new HashMap<String,Participante>()); //ja nao ha participantres
		c.setCorridas(new HashMap<Corrida,Boolean>()); // ja nao ha corridas
	}

	public String simularProximaCorrida(String nome_campeonato) {
		String resultado_corrida = null;
		Campeonato camp = this.mapCampeonatos.get(nome_campeonato);
		for(Map.Entry<Corrida,Boolean> pair : camp.getCorridas().entrySet())
			if (!pair.getValue())
				{
					resultado_corrida = camp.simulaProximaCorrida(pair.getKey().getCiruito());
					pair.setValue(false);
					break;
				}
		return resultado_corrida;
	}

	

}