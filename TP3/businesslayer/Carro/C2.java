package businesslayer.Carro;

public class C2 extends Carro {

	public C2()
	{
	super();
	}

	public C2(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, int a_fiabilidade,float o_pa, String o_estado, String os_pneus) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
	}

	public C2(C2 p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
	}

	public String toString()
	{
		return super.toString();
	}

	public C2 clone() {
		return new C2(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;

		return super.equals(o);
	}

}