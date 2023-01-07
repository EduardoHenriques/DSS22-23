package buisness;

import java.util.*;

public interface IRacingSimFacade {

	void corrida();

	/**
	 * 
	 * @param sc
	 */
	String addCircuito(String nome, int dist, int voltas, int n_retas, int n_chicanes);

	/**
	 * 
	 * @param sc
	 */
	String addCampeonato(ArrayList<String> circuitos, String nomeProva);

	/**
	 * 
	 * @param sc
	 */
	String addCarro(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void addPiloto(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void editCampeonato(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void editCircuito(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void editCarro(Scanner sc);
	
	/**
	 * 
	 * @param sc
	 */
	void editPiloto(Scanner sc);
	
	/**
	 * 
	 * @param sc
	 */
	void delCampeonato(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void delCircuito(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void delCarro(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void delPiloto(Scanner sc);

}