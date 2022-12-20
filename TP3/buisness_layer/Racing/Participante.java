
package Racing;
import Carro.*;
import Utilizador.*;

public class Participante {

	private int posicao;
	private Piloto piloto;
	private Carro carro;
	private Utilizador user;
	
	public int getPosicao() {
		return this.posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Utilizador getUtilizador(){
		return this.user;
	}

	public void setUtilizador(Utilizador user) throws ErroCampeonato {
		if(user instanceof Convidado)
				this.user = ((Convidado) user).clone();
		else if(user instanceof Jogador)
				this.user = ((Jogador) user).clone();
		else
			throw new ErroCampeonato("Administradores não podem participar em campeonatos...");
	}

	public Piloto getpiloto() {
		return this.piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Carro getCarro(){
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro= carro;
	}

	public Participante() {
			throw new UnsupportedOperationException();
	}

	public Participante(Utilizador user, Piloto piloto, Carro carro) {
		this.user = user;
		this.piloto = piloto;
		this.carro = carro;
	}

	public String toString()
	{
		return ("===PARTICIPANTE===\n" + this.user.toString() + this.piloto.toString() + this.carro.toString());
	}

}