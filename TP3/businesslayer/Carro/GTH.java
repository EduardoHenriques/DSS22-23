
public class GTH extends GT {

	private int motor_eletrico;

	public GTH()
	{
	super();
	this.motor_eletrico = 0;
	}

	public GTH(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus,float a_taxa, int o_motor_eletrico) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus,a_taxa);
		this.motor_eletrico = o_motor_eletrico;
	}

	public int getMotorEletrico()
	{
		return this.motor_eletrico;
	}

	public void setMotorEletrico(int o_motor)
	{
		this.motor_eletrico = o_motor;
	}
	
	public GTH(GTH p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus(),p.getTaxa_fiabilidade());
		this.motor_eletrico = p.getMotorEletrico();
	}
	
	public String toString()
	{
		String s =  super.toString();
		return(s + "Motor Eletrico: " + this.getMotorEletrico() + "\n" );
	}

	public GTH clone() {
		return new GTH(this);
	}

	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;
		GTH c = (GTH) o;
		return (c.getMotorEletrico() == this.getMotorEletrico() && super.equals(o));
	}

}