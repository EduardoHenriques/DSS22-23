
public class Participante {

	private int posicao = 0;
	private Piloto piloto;
	private Carro carro;
	private Utilizador user;
	
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

	public Utilizador getUtilizador(){
		return this.user;
	}

	/**
	 * 
	 * @param posicao
	 */
	public void setUtilizador(Utilizador user) {
		this.user = user;
	}

	public Piloto getpiloto() {
		return this.piloto;
	}

	/**
	 * 
	 * @param posicao
	 */
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Carro getCarro(){
		return this.carro;
	}

	/**
	 * 
	 * @param posicao
	 */
	public void setCarro(Carro carro) {
		this.carro= carro;
	}

	public Participante() {
		// TODO - implement Participante.Participante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param piloto
	 * @param carro
	 */
	public Participante(Utilizador user, Piloto piloto, Carro carro) {
		this.user = user;
		this.piloto = piloto;
		this.carro = carro;
	}

}