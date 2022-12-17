
import java.util.*;

public class FacadeCorrida implements IFacadeCorrida {

	private Campeonato campeonatos;
	private Piloto pilotos;
	private Circuito circuitos;
	private Circuito circuitos2;

	@Override
	public String resultadosCorrida(int x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String listaCircuitos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String listaParticipantes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String printClassificacao() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String simularProximaCorrida() {
		Iterator<Map.Entry<Circuito,Boolean>> circuitoIterator = campeonatos.getCircuitos().iterator();
		String vals = "Circuitos concluidos";
		while(circuitoIterator.hasNext()){	
			Map.Entry<Circuito,Boolean> entry = circuitoIterator.next();
			if(!entry.getValue()){
				vals = campeonatos.simulaProximaCorrida(entry.getKey());
				break;
			}
		}
		return vals;
	}

}