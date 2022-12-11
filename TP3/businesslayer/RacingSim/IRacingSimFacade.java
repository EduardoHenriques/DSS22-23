package businesslayer.RacingSim;

public interface IRacingSimFacade {

	void corrida();

	/**
	 * 
	 * @param sc
	 */
	void addCircuito(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void addCampeonato(Scanner sc);

	/**
	 * 
	 * @param sc
	 */
	void addCarro(Scanner sc);

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