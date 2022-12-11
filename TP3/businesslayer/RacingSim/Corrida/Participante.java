package businesslayer.RacingSim.Corrida;

import businesslayer.RacingSim.Utilizador.*;

public class Participante {

	private int posicao = 0;
	private Piloto piloto;

	public Participante() {
		// TODO - implement Participante.Participante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param u
	 * @param p
	 * @param c
	 */
	public Participante(Utilizador u, Piloto p, Carro c) {
		// TODO - implement Participante.Participante
		throw new UnsupportedOperationException();
	}

	public int getPosicao() {
		return this.posicao;
	}

	/**
	 * 
	 * @param posicao
	 */
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

}