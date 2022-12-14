package businesslayer.Corrida;

public interface IFacadeCorrida {

	/**
	 * Info corrida x
	 * @param x
	 */
	String resultadosCorrida(int x);

	/**
	 * Lista Circuitos
	 */
	String listaCircuitos();

	/**
	 * Lista Carros a participar em proxa nr x
	 */
	String listaParticipantes();

	/**
	 * Lista a classificacao atual
	 */
	String printClassificacao();

	String simularProximaCorrida();

}