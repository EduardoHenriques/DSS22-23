
public class C2 extends Carro {

	private float afinacao; // 0-1 : começa a 0.5, valor neutro

	public C2()
	{
	super();
	this.afinacao = 0.5f;
	}
	
	public C2(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus, float a_afinacao) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
		this.afinacao = a_afinacao;
	}

	public float getAfinacao()
	{
		return this.afinacao;
	}
	public void setAfinacao(float a_afinacao)
	{
		this.afinacao = a_afinacao;
	}



	public C2(C2 p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
		this.afinacao = p.afinacao;
	}

	public String toString()
	{
		return (super.toString() + "Afinaçao(0.0-1-0 || 0.5=Neutro) : " + this.afinacao +"\n");
	}

	public C2 clone() {
		return new C2(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;
		C2 c = (C2) o;
		return (super.equals(o) && c.getAfinacao() == this.getAfinacao());
	}

}