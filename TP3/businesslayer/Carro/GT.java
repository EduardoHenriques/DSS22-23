
public class GT extends Carro {

	//AFINACAO MECANICA DO GT = ...

	private float taxa_fiabilidade; // valor baixo que é subtraído à fiabilidade com o desenrolar da corrida. Calculado quando o carro é construido

	public GT()
	{
	super();
	}

	public GT(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus, float a_taxa) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
		this.taxa_fiabilidade = a_taxa;
	}

	public float getTaxa_fiabilidade(){
		return this.taxa_fiabilidade;
	}

	public void setTaxa_fiabilidade(float uma_taxa){
		this.taxa_fiabilidade = uma_taxa;
	}

	public GT(GT p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
		this.taxa_fiabilidade = p.getTaxa_fiabilidade();
	}

	public String toString(){
		return (super.toString() + "Taxa de Fiabilidade: " + this.getTaxa_fiabilidade() + "\n");
	}

	public GT clone() {
		return new GT(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;
		GT c = (GT) o;
		return (super.equals(o) && this.getTaxa_fiabilidade() == c.getTaxa_fiabilidade());
	}

}