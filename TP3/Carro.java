import java.io.*;

public abstract class Carro implements Comparable<Carro>, Serializable {

	/**
	 * Variaveis de instancia
	 */
	private String marca;
	private String modelo;
	private int cilindrada;
	private int potencia;
	private float fiabilidade;
	private long tempo;
	private boolean dnf;
	private float pa;
	private estado estadoMotor;
	private tipoPneu pneus;

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return this.cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getPotencia() {
		return this.potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public float getFiabilidade() {
		return this.fiabilidade;
	}

	public long getTempo() {
		return this.tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	/**
	 * Construtores
	 */
	public Carro() {
		// TODO - implement Carro.Carro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param marca
	 * @param modelo
	 * @param cilindrada
	 * @param potencia
	 * @param e
	 * @param fiabilidade
	 */
	public Carro(String marca, String modelo, int cilindrada, int potencia, Equipa e, int fiabilidade) {
		// TODO - implement Carro.Carro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public Carro(Carro c) {
		// TODO - implement Carro.Carro
		throw new UnsupportedOperationException();
	}

	public boolean getDNF() {
		// TODO - implement Carro.getDNF
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param b
	 */
	public void setDNF(boolean b) {
		// TODO - implement Carro.setDNF
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodos usuais
	 */
	public abstract Carro clone();

	public String toString() {
		// TODO - implement Carro.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public boolean equals(Object o) {
		// TODO - implement Carro.equals
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public int compareTo(Carro c) {
		// TODO - implement Carro.compareTo
		throw new UnsupportedOperationException();
	}

	/**
	 * Tempo em milisegundos de uma volta
	 * @param c
	 * @param clima
	 * @param volta
	 */
	public long tempoProximaVolta(Circuito c, int clima, int volta) {
		// TODO - implement Carro.tempoProximaVolta
		throw new UnsupportedOperationException();
	}

	/**
	 * define se o carro desiste (true desiste, false continua em prova)
	 * @param volta
	 * @param totalvoltas
	 * @param clima
	 */
	public abstract boolean DNF(int volta, int totalvoltas, int clima);

	/**
	 * 
	 * @param estadoMotor
	 */
	public void setEstadoMotor(int estadoMotor) {
		// TODO - implement Carro.setEstadoMotor
		throw new UnsupportedOperationException();
	}

	public void getEstadoMotor() {
		// TODO - implement Carro.getEstadoMotor
		throw new UnsupportedOperationException();
	}

	public tipoPneu getPneus() {
		return this.pneus;
	}

	/**
	 * 
	 * @param pneus
	 */
	public void setPneus(tipoPneu pneus) {
		this.pneus = pneus;
	}

}