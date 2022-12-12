import java.io.*;
import java.util.Random;
import Participantes
import businesslayer.RacingSim.Carro.Carro;
import businesslayer.RacingSim.Corrida.*;

public class Corrida implements Serializable {

	Circuito circuito;
	private java.util.Map<Participante, Integer> dnf;
	private int clima;
	private Random random;
	private float Tempos;
	private List<Participantes> participantes;
	private int volta = 0;

	public int getClima() {
		return this.clima;
	}

	/**
	 * 1-chove 0-sol
	 * 
	 * Construtores
	 */
	public Corrida() {
		// TODO - implement Corrida.Corrida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 * @param c
	 * @param r
	 * @param p
	 * @param clima
	 * @param lp
	 */
	public Corrida(java.util.List<Carro> l, Circuito c, java.util.Set<Carro> r, java.util.List<Carro> p, int clima, List<Piloto> lp) {
		// TODO - implement Corrida.Corrida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public Corrida(Corrida c) {
		// TODO - implement Corrida.Corrida
		throw new UnsupportedOperationException();
	}

	public java.util.Map<Carro, Integer> getDNF() {
		// TODO - implement Corrida.getDNF
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodos
	 */
	public Corrida clone() {
		// TODO - implement Corrida.clone
		throw new UnsupportedOperationException();
	}

	/**
	 * Simula a corrida
	 */
	public void simulaCorrida() {
		// TODO - implement Corrida.simulaCorrida
		throw new UnsupportedOperationException();
	}

	/**
	 * Lista os resultados da corrida.
	 */
	public String printResultados() {
		// TODO - implement Corrida.printResultados
		throw new UnsupportedOperationException();
	}

	/**
	 * Lista de Acidentados DNF
	 */
	public String printDNF() {
		// TODO - implement Corrida.printDNF
		throw new UnsupportedOperationException();
	}

	public java.util.List<Participantes> getParticipantes() {
		// TODO - implement Corrida.getParticipantes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 * @param sec
	 */
	public void verificaUltrapassagemPrem(List<Participantes> l, Seccao sec) {
		// TODO - implement Corrida.verificaUltrapassagemPrem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 * @param sec
	 */
	public void verificarUltrapassagem(List<Participantes> l, Seccao sec) {
		// TODO - implement Corrida.verificarUltrapassagem
		throw new UnsupportedOperationException();
	}

	public void atualizarPosicoes() {
		// TODO - implement Corrida.atualizarPosicoes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param voltas
	 */
	public void verificaFalhaMotor(int voltas) {
		// TODO - implement Corrida.verificaFalhaMotor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param participante
	 * @param volta
	 */
	public void falhaMotor(Participante participante, int volta) {
		// TODO - implement Corrida.falhaMotor
		throw new UnsupportedOperationException();
	}

	public boolean haPremium() {
		// TODO - implement Corrida.haPremium
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaParticipantes
	 * @param participante
	 */
	public void avancaUm(List<Participantes> listaParticipantes, Participante participante) {
		// TODO - implement Corrida.avancaUm
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaParticipantes
	 * @param participante
	 */
	public void vaiUlt(List<Participantes> listaParticipantes, Participante participante) {
		// TODO - implement Corrida.vaiUlt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param agrPiloto
	 * @param pneus
	 * @param clima
	 * @param vsPiloto
	 */
	public boolean calculaCrash(float agrPiloto, tipoPneu pneus, int clima, float vsPiloto) {
		// TODO - implement Corrida.calculaCrash
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param estadoMotor
	 * @param fiabCarro
	 * @param cilindCarro
	 * @param voltas
	 */
	public boolean calculaFalha(Estado estadoMotor, float fiabCarro, int cilindCarro, int voltas) {
		// TODO - implement Corrida.calculaFalha
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param participante
	 */
	public boolean getTimeDiff(Participante participante) {
		// TODO - implement Corrida.getTimeDiff
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param carro
	 * @param piloto
	 * @param clima
	 * @param seccao
	 */
	public boolean tentaUltrapassagem(Carro carro, Piloto piloto, int clima, Seccao seccao) {
		// TODO - implement Corrida.tentaUltrapassagem
		throw new UnsupportedOperationException();
	}

}