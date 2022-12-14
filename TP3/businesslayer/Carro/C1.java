
public class C1 extends Carro {

	
	public C1()
	{
	super();
	}
	
	public C1(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
	}
	
	//CONSTRUTOR DEFAULT -> VIABILIDADE 0.95 NOS C1, SEMPRE
	public C1(String a_marca, String o_modelo, int a_cilindrada, int a_potencia,float o_pa)
	{
	 super(a_marca,o_modelo,a_cilindrada,a_potencia,o_pa);
	 this.setFiabilidade(0.95f);
	}

	public C1(C1 p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
	}

	public String toString()
	{
		return super.toString();
	}

	public C1 clone() {
		return new C1(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;

		return super.equals(o);
	}

	

}