package Racing;

import java.util.*;

public class FacadeCorrida implements IFacadeCorrida {

	private HashMap <String,Campeonato> mapCampeonatos;
	private HashMap <String,Piloto> mapPilotos;
	private HashMap <String,Participante> mapParticipantes;
	private HashMap <String,Circuito> mapCircuitos;
	private HashMap <String,Seccao> mapSeccoes;

	public String resultadosCorrida() {
		return null;
	}
	public String listaCircuitos() {
		return null;
	}
	public String listaParticipantes() {
		return null;
	}
	public String printClassificacao() {
		return null;
	}

	public void startCampeonato(Campeonato c)
	{
		ArrayList<Participante> participantes = new ArrayList<>(c.getListaPart().values());
		for(Circuito circ : c.getCircuitos())
		{
			Corrida corr = new Corrida(circ.clone(),(int)Math.round(Math.random()),participantes);
			c.getCorridas().put(corr,false);
		}
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