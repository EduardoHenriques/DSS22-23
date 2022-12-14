
public class C2H extends C2 {

	private int motor_eletrico;

	public C2H()
	{
	super();
	this.motor_eletrico = 0;
	}

	public C2H(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus, int o_motor_eletrico, float a_afinacao) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus,a_afinacao);
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

	public C2H(C2H p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus(),p.getAfinacao());
		this.motor_eletrico = p.getMotorEletrico();
	}
	
	public String toString()
	{
		String s =  super.toString();
		return(s + "Motor Eletrico: " + this.getMotorEletrico() + "\n" );
	}

	public C2H clone() {
		return new C2H(this);
	}


	public boolean equals(Object o) {
	   if(this == o) 
       	return true;
       if(o == null || o.getClass() != this.getClass())
       	return false;
		C2H c = (C2H) o;
		return (c.getMotorEletrico() == this.getMotorEletrico() && super.equals(o));
	}

}