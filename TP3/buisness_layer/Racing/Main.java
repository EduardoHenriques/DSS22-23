package Racing;
import Carro.tipoPneu;

public class Main {
    public static void main (String args[])
    {
     Corrida corrida = new Corrida(null, 0, null);
     System.out.println(corrida.probClima(tipoPneu.MACIO,0,0.5f));
    }
}
