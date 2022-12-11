import businesslayer.RacingSim.Utilizador.*;
import java.io.*;

public class Jogador extends Utilizador implements Comparable<Jogador>, Serializable {

	private String password;
	private int points;
	private boolean isPremium;

	public int getPoints() {
		return this.points;
	}

	/**
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	public String getPass() {
		// TODO - implement Jogador.getPass
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param password
	 */
	public void setPass(String password) {
		// TODO - implement Jogador.setPass
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param password
	 */
	public Jogador(String password) {
		// TODO - implement Jogador.Jogador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public Jogador(Jogador j) {
		// TODO - implement Jogador.Jogador
		throw new UnsupportedOperationException();
	}

	public Jogador clone() {
		// TODO - implement Jogador.clone
		throw new UnsupportedOperationException();
	}

	public boolean getIsPremium() {
		return this.isPremium;
	}

	/**
	 * 
	 * @param isPremium
	 */
	public void setIsPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

}