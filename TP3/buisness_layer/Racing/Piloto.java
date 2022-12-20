package Racing;
import java.io.*;


public class Piloto implements Serializable {

	/**
	 * Variaveis de instancia
	 */
	private String nome;
	private float chuvaVSseco;
	private float agressividade;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getAgressividade() {
		return this.agressividade;
	}

	public void setAgressividade(float agressividade) {
		this.agressividade = agressividade;
	}

	/**
	 * Construtores
	 */
	public Piloto() {
		// TODO - implement Piloto.Piloto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 * @param nacionalidade
	 * @param qual
	 * @param chuvaVSseco
	 * @param agressividade
	 */
	public Piloto(String nome, String nacionalidade, int qual, float chuvaVSseco, float agressividade) {
		// TODO - implement Piloto.Piloto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public Piloto(Piloto p) {
		// TODO - implement Piloto.Piloto
		throw new UnsupportedOperationException();
	}

	public float getChuvaVSseco() {
		return this.chuvaVSseco;
	}

	/**
	 * 
	 * @param chuvaVSseco
	 */
	public void setChuvaVSseco(float chuvaVSseco) {
		this.chuvaVSseco = chuvaVSseco;
	}

	/**
	 * Metodos usuais
	 */
	public String toString() {
		// TODO - implement Piloto.toString
		throw new UnsupportedOperationException();
	}

	public Piloto clone() {
		// TODO - implement Piloto.clone
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public boolean equals(Object o) {
		// TODO - implement Piloto.equals
		throw new UnsupportedOperationException();
	}

}