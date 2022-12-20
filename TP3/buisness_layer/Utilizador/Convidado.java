package Utilizador;

public class Convidado extends Utilizador {

	public Convidado() {
		super();
	}

	public Convidado(Convidado c) {
		super(c.getUser());
	}

	public Convidado clone() {
		return new Convidado(this);
	}

	public String toString()
	{
		return ("====CONVIDADO====\n" + super.toString());
	}

	public boolean equals(Object o)
	{
		return super.equals(o);
	}


}