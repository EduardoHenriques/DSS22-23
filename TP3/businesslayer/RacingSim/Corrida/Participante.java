package businesslayer.RacingSim.Corrida;

import businesslayer.RacingSim.Utilizador.*;
import businesslayer.RacingSim.Carro.Carro;

public class Participante {

	private int posicao = 0;
	private Piloto piloto;
	private Utilizador user;
	
	public int getPosicao() {
		return this.posicao;
	}
	public Utilizador getUtilizador(){
		return this.user;
	}

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

	/**
	 * 
	 * @param posicao
	 */
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

}