package businesslayer.Carro;


enum estadoMotor{
CONSERVADOR,
NORMAL,
AGRESSIVO,
NULL;

    public static estadoMotor fromString(String str)
    {
	 switch (str)
	 	{
		case("conservador"):
			return CONSERVADOR;
		case("normal"):
			return NORMAL;
		case("agressivo"):
			return AGRESSIVO;
		default:
			return NULL;	
		}
    }
	public static String toStr(estadoMotor estado)
	{
	 switch(estado)
		{
		case CONSERVADOR:
			return "conservador";
		case NORMAL:
			return "normal";
		case AGRESSIVO:
			return "agressivo";
		default:
			return "s/ estado";
		}
	}

}

public enum tipoPneu{
MACIO,
DURO,
CHUVA,
NULL;
    public static tipoPneu fromString(String str)
    {
	 switch (str)
	 	{
		case("macio"):
			return MACIO;
		case("duro"):
			return DURO;
		case("chuva"):
			return CHUVA;
		default:
			return NULL;	
		}
    }
	public static String toStr(tipoPneu pneus)
	{
	 switch(pneus)
		{
		case MACIO:
			return "macio";
		case DURO:
			return "duro";
		case CHUVA:
			return "chuva";
		default:
			return "s/ tipo pneus";
		}
	}

	
}

