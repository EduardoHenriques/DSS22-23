

public abstract class Carro  {

	private String marca;
	private String modelo;
	private int cilindrada;
	private int potencia;
	private float fiabilidade;
	private float pa;			//perfil aerodinamico
	private estadoMotor estado;
	private tipoPneu pneus;


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
	   public Carro(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus) {
		
		   this.marca = a_marca;
		   this.modelo = o_modelo;
		   this.cilindrada = a_cilindrada;
		   this.potencia = a_potencia;
		   this.fiabilidade = a_fiabilidade;
		   this.pa = o_pa;
		   this.estado = o_estado;
		   this.pneus = os_pneus;
		
	   }

	   //CONSTRUTOR DEFAULT, PNEUS+MOTOR (E EM CERTOS CASOS FIABILIADE) SAO CALCULADOS NO CAMPEONATO
	   public Carro(String a_marca, String o_modelo, int a_cilindrada, int a_potencia,float o_pa)
	   {
		this.marca = a_marca;
		this.modelo = o_modelo;
		this.cilindrada = a_cilindrada;
		this.potencia = a_potencia;
		this.fiabilidade = 0f;
		this.pa = o_pa;
		this.estado = estadoMotor.NULL;
		this.pneus = tipoPneu.NULL;
	   }
	
	 
	 

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

	public void setFiabilidade(float a_fiabilidade)
	{
		this.fiabilidade = a_fiabilidade;
	}

	public float getPa()
	{
		return this.pa;
	}

	public void setPa(float o_pa)
	{
		this.pa = o_pa;
	}

	public void setPneus(tipoPneu os_pneus)
	{
		this.pneus = os_pneus;
	}

	public tipoPneu getPneus()
	{
		return this.pneus;
	}

	public void setEstado(estadoMotor o_estado)
	{
		this.estado = o_estado;
	}

	public estadoMotor getEstado()
	{
		return this.estado;
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
		return (out + "Marca: " + this.getMarca() + "\nModelo: " +  this.getModelo() +  "\nCilindrada: " +
				 this.getCilindrada() + "\nPotencia: " + this.getPotencia() + "\nFiabilidade: " + this.getFiabilidade()
				 + "\nPerfil Aerodinamico: " + this.getPa() + "\nEstado do motor: " + estadoMotor.toStr(this.getEstado())
				 + "\nTipo de pneus: " + tipoPneu.toStr(this.getPneus()) + "\n");
	}




	public boolean equals(Object o) {
		if (this == o)
			return true;
		if(o == null || o.getClass() != this.getClass())
			return false;
		Carro c = (Carro) o;
		return(this.getMarca() == c.getMarca() && this.getModelo() == c.getModelo() && this.getCilindrada() == c.getCilindrada()
		&& this.getPotencia() == c.getPotencia() && this.getFiabilidade() == c.getFiabilidade() && this.getPa() == c.getPa()
		&& this.getEstado() == c.getEstado() && this.getPneus() == c.getPneus());

	}





}