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

	public String simularProximaCorrida(String nome_campeonato) {
		String resultado_corrida = null;
		Campeonato camp = this.mapCampeonatos.get(nome_campeonato);
		for(Map.Entry<Circuito,Boolean> pair : camp.getCircuitos())
			if (!pair.getValue())
				{
					resultado_corrida = camp.simulaProximaCorrida(pair.getKey());
					pair.setValue(false);
					break;
				}
		return resultado_corrida;
	}


}