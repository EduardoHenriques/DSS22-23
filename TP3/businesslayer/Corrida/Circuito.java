import java.io.*;
import java.util.ArrayList;


public class Circuito implements Serializable {

	private String nome;
	private int distancia;
	private int voltas;
	private ArrayList<Seccao> listaSeccoes;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDistancia() {
		return this.distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getVoltas() {
		return this.voltas;
	}

	public void setVoltas(int voltas) {
		this.voltas = voltas;
	}

	public void setListaSeccoes(ArrayList<Seccao> listaSeccoes) {
		this.listaSeccoes = listaSeccoes;
	}

	public ArrayList<Seccao> getListaSeccoes() {
		return this.listaSeccoes;
	}

	public Circuito() {}

	public Circuito(String n, int d, int v, ArrayList<Seccao> l) {
		this.nome = n;
		this.distancia = d;
		this.voltas = v;
		for (Seccao s : l) {
			this.listaSeccoes.add(s.clone());
		}
	}

	public Circuito(Circuito c) {
		this.nome = c.getNome();
		this.distancia = c.getDistancia();
		this.voltas = c.getVoltas();
		for (Seccao s : c.getListaSeccoes()) {
			this.listaSeccoes.add(s.clone());
		}
	}

	public Circuito createCircuito(String nome, int dist, int voltas, int n_retas, int n_chicanes) {
		Circuito c = new Circuito();
		c.setNome(nome);
		c.setDistancia(dist);
		c.setVoltas(voltas);
		int curvas = (n_retas + n_chicanes) / 2;
		for (int i = 0; i < n_retas ; i++) {
			c.getListaSeccoes().add(new Seccao(1));
		}
		for (int i = 0; i < curvas ; i++) {
			c.getListaSeccoes().add(new Seccao(0));
		}
		for (int i = 0; i < n_chicanes ; i++) {
			c.getListaSeccoes().add(new Seccao(2));
		}
		return c;
	}

	public Circuito clone() {
		return new Circuito(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Circuito circuito = (Circuito) o;

		if (distancia != circuito.distancia) return false;
		if (voltas != circuito.voltas) return false;
		if (nome != null ? !nome.equals(circuito.nome) : circuito.nome != null) return false;
		return listaSeccoes != null ? listaSeccoes.equals(circuito.listaSeccoes) : circuito.listaSeccoes == null;
	}

}