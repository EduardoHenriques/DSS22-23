package Utilizador;

public class Administrador extends Utilizador {

	private String password;

	public Administrador(String n, String pass) {
		super(n);
		this.password = pass;
	}

	public Administrador(Administrador a) {
		super(a);
		this.password = a.getPass();
	}

	public void setPass(String password) {
		this.password = password;
	}

	public String getPass() {
		return this.password;
	}

	public Administrador clone() {
		return new Administrador(this);
	}

}