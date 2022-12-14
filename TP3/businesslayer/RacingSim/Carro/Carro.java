package businesslayer.RacingSim.Carro;
import java.io.*;
import businesslayer.RacingSim.Carro.estadoMotor;
import businesslayer.RacingSim.Carro.tipoPneu;


public abstract class Carro implements FacadeCarro, Serializable {

	private String marca;
	private String modelo;
	private int cilindrada;
	private int potencia;
	private float fiabilidade;
	private float pa;			//perfil aerodinamico
	private estadoMotor estado;
	private tipoPneu pneus;

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return this.cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getPotencia() {
		return this.potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public float getFiabilidade() {
		return this.fiabilidade;
	}

	public float getPa()
	{
		return this.pa;
	}

	public void setPa(float o_pa)
	{
		this.pa = o_pa;
	}

	public void setPneus(String os_pneus)
	{
		this.pneus = tipoPneu.fromString(os_pneus);
	}

	public tipoPneu getPneus()
	{
		return this.pneus;
	}

	public void setEstado(String o_estado)
	{
		this.estado = estadoMotor.fromString(o_estado);
	}

	public estadoMotor getEstado()
	{
		return this.estado;
	}



	/**
	 * Construtores
	 */
	public Carro() {
	 marca = "";
	 modelo = "";
	 cilindrada = 0;
	 potencia = 0;
	 fiabilidade = 0;
	 pa = 0;
	 estado = estadoMotor.NULL;
	 pneus = tipoPneu.NULL;
		
	}

	public Carro(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, int a_fiabilidade,float o_pa, String o_estado, String os_pneus) {

		this.marca = a_marca;
		this.modelo = o_modelo;
		this.cilindrada = a_cilindrada;
		this.potencia = a_potencia;
		this.fiabilidade = a_fiabilidade;
		this.pa = o_pa;
		this.estado = estadoMotor.fromString(o_estado);
		this.pneus = tipoPneu.fromString(os_pneus);

	}

	public Carro(Carro c) {

		marca = c.getMarca();
		modelo = c.getModelo();
		cilindrada = c.getCilindrada();
		potencia = c.getPotencia();
		fiabilidade = c.getFiabilidade();
		pa = c.getPa();
		estado = c.getEstado();
		pneus = c.getPneus();

	}



	public String toString() {
		String out = "";
		return (out + "Marca: " + this.getMarca() + "\nodelo: " +  this.getModelo() +  "\nCilindrada: " +
				 this.getCilindrada() + "\nPotencia: " + this.getPotencia() + "\nFiabilidade: " + this.getFiabilidade()
				 + "\nPerfil Aerodinamico: " + this.getPa() + "\nEstado do motor: " + estadoMotor.toStr(this.getEstado())
				 + "\nTipo de pneus: " + tipoPneu.toStr(this.getPneus()) + "\n");
	}

	public boolean equals(Object o) {
		if (this == o)
		{
			return true;
		}
		if(o == null || o.getClass() != this.getClass())
		{
			return false;
		}
		Carro c = (Carro) o;
		return(this.getMarca() == c.getMarca() && this.getModelo() == c.getModelo() && this.getCilindrada() == c.getCilindrada()
		&& this.getPotencia() == c.getPotencia() && this.getFiabilidade() == c.getFiabilidade() && this.getPa() == c.getPa()
		&& this.getEstado() == c.getEstado() && this.getPneus() == c.getPneus());

	}







}