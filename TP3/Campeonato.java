import java.io.*;
import businesslayer.RacingSim.Corrida.*;
import java.util.*;

public class Campeonato implements Serializable {

	private java.util.Map<String, Integer> classificacao;
	private int numCorrida;
	private String prova;
	private Participante participantes;
	private Collection<Corrida> corridas;

	public java.util.Map<String, Integer> getClassificacao() {
		return this.classificacao;
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
	private java.util.List<Map.Entry<String, Integer>> ordenaClassificacao(java.util.Map<String, Integer> classificacao) {
		// TODO - implement Campeonato.ordenaClassificacao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param participante
	 * @param piloto
	 * @param jogador
	 */
	public void addParticipante(Participante participante, String piloto, String jogador) {
		// TODO - implement Campeonato.addParticipante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numCorrida
	 */
	public void setNumCorrida(int numCorrida) {
		this.numCorrida = numCorrida;
	}

	public int getNumCorrida() {
		return this.numCorrida;
	}

	public String getProva() {
		return this.prova;
	}

	/**
	 * 
	 * @param prova
	 */
	public void setProva(String prova) {
		this.prova = prova;
	}

}