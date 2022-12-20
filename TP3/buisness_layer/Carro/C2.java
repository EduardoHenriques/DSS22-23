package Carro;
public class C2 extends Carro {

	private float downforce = 0.5f;
	//aproximadamente 80% fiabilidade c/ downforce 0.5(NEUTRA)

	public float getDownforce()
	{
		return this.downforce;
	}

	//antes de entrar num campeonato, aplicamos esta função aos C2 e C2H de acordo com o que o user quer.
	// valor inserido == 0.5 -> nao faz nada
	// valor inserido > 0.5 -> ++ % ultrapassar em curva, -- % ultrapassar em reta
	// valor inserido < 0.5 -> -- % ultrapassar em curva, ++ % ultrapassar em reta
	public void setDownforce(float a_downforce)
	{
		if(a_downforce < 0f)
			this.downforce = 0f;
		if(a_downforce > 1f)
			this.downforce = 1f;
		else
			this.downforce = a_downforce;
	}

	public C2()
	{
	super();
	this.downforce = 0.5f;
	}

	public C2(String a_marca, String o_modelo, int a_cilindrada, int a_potencia, float a_fiabilidade,float o_pa, estadoMotor o_estado, tipoPneu os_pneus, float a_downforce) {
		super(a_marca,o_modelo,a_cilindrada,a_potencia,a_fiabilidade,o_pa,o_estado,os_pneus);
		this.downforce = a_downforce;
	}
	
	//Construtor default, a downforce fica sempre neutra até o carro ser selecionado para o campeonato.
	public C2(String a_marca, String o_modelo, int a_cilindrada, int a_potencia,float o_pa) throws CarroInvalido
	{
		super(a_marca,o_modelo,a_cilindrada,a_potencia,o_pa);
		if(a_cilindrada <3000 || a_cilindrada > 5000 || a_potencia < 300 || a_potencia > 900 || o_pa < 0f || o_pa > 1.00f)
			throw new CarroInvalido("Valores inválidos inseridos...");
		
		//fiabilidade entre 0.75 e 0.85
		//    vvvvvvv	
		this.setFiabilidade(0.85f - (float)(0.05 * (a_potencia - 300) / 600) - (float)(0.05 * (5000 - a_cilindrada) / 2000) );	
		this.setPneus(tipoPneu.NULL);
		this.setEstado(estadoMotor.NULL);
		this.setDownforce(0.5f);

	}
	


	public C2(C2 p) {
		super(p.getMarca(),p.getModelo(),p.getCilindrada(),p.getPotencia(),p.getFiabilidade(),p.getPa(),p.getEstado(),p.getPneus());
	}

	public String toString()
	{
		return (super.toString() + "Downforce: " + this.downforce + "\n");
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