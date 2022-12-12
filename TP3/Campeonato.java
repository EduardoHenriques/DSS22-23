import java.io.*;
import businesslayer.RacingSim.Corrida.*;
import java.util.*;

public class Campeonato implements Serializable {

	private Map<String, Integer> classificacao;
	private int numCorrida;
	private String prova;
	private Map<String, Participante> participantes;
	private Collection<Corrida> corridas;
	private Set<Circuito> circuitos;

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

	public Set<Circuito> getCircuitos(){
		return this.circuitos;
	}

	public void setCircuitos(Set<Circuito> lcir){
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
	 * @param cor
	 * @param cla
	 * @param prova
	 */
	public Campeonato(java.util.List<Corrida> cor, java.util.Map<String, Integer> cla, String prova) {
		// TODO - implement Campeonato.Campeonato
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public Campeonato(Campeonato c) {
		// TODO - implement Campeonato.Campeonato
		throw new UnsupportedOperationException();
	}

	/**
	 * Adicionar corrida ao campeonato
	 * @param c
	 */
	public void addCircuito(Circuito c) {
		// TODO - implement Campeonato.addCircuito
		throw new UnsupportedOperationException();
	}

	/**
	 * Atualizar classificacao campeonato
	 */
	public void atualizarClassificacao() {
		// TODO - implement Campeonato.atualizarClassificacao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param classificacao
	 */
	public List<Map.Entry<String, Integer>> ordenaClassificacao(Map<String, Integer> classificacao) {
		// TODO - implement Campeonato.ordenaClassificacao
		throw new UnsupportedOperationException();
	}

}