package Racing;
import java.io.*;
import java.security.KeyStore.Entry;

import java.util.*;

public class Campeonato implements Serializable {

	private Map<String, Integer> classificacao;
	private int numCorrida;
	private String prova;
	private Map<String, Participante> participantes;
	private Collection<Corrida> corridas;
	private Set<Map.Entry<Circuito, Boolean>> circuitos;
	
	public void setNumCorrida(int numCorrida) {
		this.numCorrida = numCorrida;
	}

	public int getNumCorrida() {
		return this.numCorrida;
	}

	public String getProva() {
		return this.prova;
	}

	public void setProva(String prova) {
		this.prova = prova;
	}

	public Map<String, Integer> getClassificacao() {
		return this.classificacao;
	}

	public Map<String, Participante> getListaPart(){
		return this.participantes;
	}

	public void setListaPart(Map<String, Participante> listaP){
		this.participantes = listaP;
	}

	public Set<java.util.Map.Entry<Circuito, Boolean>> getCircuitos(){
		return this.circuitos;
	}

	public void setCircuitos(Set<java.util.Map.Entry<Circuito, Boolean>> lcir){
		this.circuitos = lcir;
	}

	public Participante getParticipante(String part){
		return this.participantes.get(part);
	}

	/**
	 * 
	 * @param participante
	 * @param piloto
	 * @param jogador
	 */
	public void addParticipante(Participante participante) {
		String nomeU = participante.getUtilizador().getUser();
		this.participantes.put(nomeU, participante);
	}

	/**
	 * incrementa a cada prova realizada (aponta para a prova a realizar)
	 */
	public Campeonato() {
		// TODO - implement Campeonato.Campeonato
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param circuitos os circuitos a utilizar neste campeonato
	 * @param prova nome do campeonato
	 */
	public Campeonato(Set<Map.Entry<Circuito, Boolean>> circuitos, String prova) {
		this.circuitos = circuitos;
		this.prova = prova;		
	}

	public Campeonato(Campeonato c) {
		this.circuitos = c.circuitos;
		this.classificacao = c.classificacao;
		this.corridas = c.corridas;
		this.numCorrida = c.numCorrida;
		this.participantes = c.participantes;
		this.prova = c.prova;
	}

	/**
	 * Adicionar corrida ao campeonato
	 * @param c circuito a adicionar
	 */
	public void addCircuito(Circuito c) {
		Map.Entry<Circuito,Boolean> entry = new AbstractMap.SimpleEntry<Circuito, Boolean>(c, false);
		circuitos.add(entry);
	} 

	/**
	 * Atualizar classificacao campeonato
	 */
	public void atualizarClassificacao(List<Participante> participantes){
		int max = 12;
		for(Participante p : participantes){
			int points = this.classificacao.get(p.getUtilizador().getUser());
			int pos = p.getPosicao();
			switch(pos){
				case 1:
					points += max;
					break;
				case 2:
					points += max-2;
					break;
				default:
					points += max -(pos+1);
			}
		}
	}

	public String simulaProximaCorrida(Circuito cir){
		List<Participante> part = new ArrayList<Participante>();
		int i = 1;
		for(Participante p : this.participantes.values()){
			p.setPosicao(i);
			part.add(p);
			i++;
		}
		Corrida corrida = new Corrida(cir, 2, part);
		List<Participante> listaPart = corrida.simulaCorrida();
		atualizarClassificacao(listaPart);
		ArrayList<Map.Entry<String, Integer>> camp = ordenaClassificacao(this.classificacao);
		String strClassificacoes = "";
		for(Map.Entry<String, Integer> entry : camp){
			String str = entry.getValue() + "º  " + entry.getKey()+ "\n";
			strClassificacoes += str; 
		}
		return strClassificacoes;
	}

	/**
	 * 
	 * @param classificacao
	 */
	public ArrayList<Map.Entry<String, Integer>> ordenaClassificacao(Map<String, Integer> classificacao) {
		ArrayList<Map.Entry<String, Integer>> lista = new ArrayList<Map.Entry<String, Integer>>();
		for (String key : classificacao.keySet()) {
			Map.Entry<String,Integer> entry = new AbstractMap.SimpleEntry<String, Integer>(key, classificacao.get(key));
			lista.add(entry);
		}
		Collections.sort(lista, new StockComparator());
		return lista;
}


class StockComparator implements Comparator<Map.Entry<String, Integer>> {
	// override the compare() method
	public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2)
	{
		if (p1.getValue() == p1.getValue())
		return 0;
		else if (p1.getValue() > p1.getValue())
		return 1;
		else
		return -1;
	}
}
}