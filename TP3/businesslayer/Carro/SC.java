

public class SC extends Carro {

	//FIABILIDADE DO SC -> 75% CARRO + 25% PILOTO
	public SC()
	{
	super();
	}

	public SC(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
	}

	public SC(SC p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
	}
	
	public String toString()
	{
		return super.toString();
	}

	public SC clone() {
		return new SC(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;
		
		return super.equals(o);
	}

}