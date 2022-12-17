
public class C2 extends Carro {


	//aproximadamente 80% fiabilidade

	public C2()
	{
	super();
	}

	//Construtor default
	public C2(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
	}

	public C2(String a_marca, String o_modelo, int a_cilindrada, int a_potencia,float o_pa) throws CarroInvalido
	{
		super(a_marca,o_modelo,a_cilindrada,a_potencia,o_pa);
		if(a_cilindrada <3000 || a_cilindrada > 5000 || a_potencia < 300 || a_potencia > 900 || o_pa < 0f || o_pa > 1.00f)
			throw new CarroInvalido("Valores inválidos inseridos...");
		
		//fiabilidade entre 0.75 e 0.85
		//    vvvvvvv	
		this.setFiabilidade(0.85f - (float)(0.05 * (a_potencia - 300) / 600) - (float)(0.05 * (5000 - a_cilindrada) / 2000) ) ;	
		this.setPneus(tipoPneu.NULL);
		this.setEstado(estadoMotor.NULL);

	}


	public C2(C2 p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
	}

	public String toString()
	{
		return (super.toString());
	}

	public C2 clone() {
		return new C2(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;
		return (super.equals(o));
	}

}