import java.io.*;
import businesslayer.RacingSim.Corrida.*;

public class Circuito implements Serializable {

	/**
	 * Variaveis instancia
	 */
	private String nome;
	private int distancia;
	private int voltas;
	private Seccao[] listaSeccoes;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDistancia() {
		return this.distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getVoltas() {
		return this.voltas;
	}

	public void setVoltas(int voltas) {
		this.voltas = voltas;
	}

	/**
	 * Construtores
	 */
	public Circuito() {
		// TODO - implement Circuito.Circuito
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param n
	 * @param d
	 * @param v
	 * @param m
	 * @param ds
	 * @param b
	 * @param r
	 */
	public Circuito(String n, int d, int v, java.util.Map<String, Long> m, long ds, long b, Record r) {
		// TODO - implement Circuito.Circuito
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public Circuito(Circuito c) {
		// TODO - implement Circuito.Circuito
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param n_retas
	 * @param n_chicanes
	 */
	public Circuito createCircuito(int n_retas, int n_chicanes) {
		// TODO - implement Circuito.createCircuito
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodos usuais
	 */
	public Circuito clone() {
		// TODO - implement Circuito.clone
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Circuito.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public boolean equals(Object o) {
		// TODO - implement Circuito.equals
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaSeccoes
	 */
	public void setListaSeccoes(List<Seccao> listaSeccoes) {
		// TODO - implement Circuito.setListaSeccoes
		throw new UnsupportedOperationException();
	}

	public List<Seccao> getListaSeccoes() {
		// TODO - implement Circuito.getListaSeccoes
		throw new UnsupportedOperationException();
	}

}