import java.io.*;

public class Record implements Serializable {

	/**
	 * Variaveis de instancia
	 */
	private long tempo;
	private Piloto piloto;
	private Carro carro;

	public long getTempo() {
		return this.tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public Piloto getPiloto() {
		return this.piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	/**
	 * Construtores
	 */
	public Record() {
		// TODO - implement Record.Record
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param p
	 * @param c
	 */
	public Record(long t, Piloto p, Carro c) {
		// TODO - implement Record.Record
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public Record(Record c) {
		// TODO - implement Record.Record
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodos usuais
	 */
	public Record clone() {
		// TODO - implement Record.clone
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Record.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public boolean equals(Object o) {
		// TODO - implement Record.equals
		throw new UnsupportedOperationException();
	}

}