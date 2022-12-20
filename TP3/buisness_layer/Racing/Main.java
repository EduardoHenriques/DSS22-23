package Racing;
import Carro.tipoPneu;
import Utilizador.*;
import Carro.*;

public class Main {
    public static void main (String args[])
    {
     Corrida corrida = new Corrida(null, 0, null);
     System.out.println(corrida.probClima(tipoPneu.MACIO,0,0.5f));
     try
     {
        Utilizador j = new Jogador("eu","123",0,false);
        Carro c2 = new C2H("Mercedes","Bruh",4500,500,0.32f,60);
        Piloto p = new Piloto("Joaquim",0.2f,0.6f);
        Participante part = new Participante(j,p,c2);
        System.out.println(part.toString());
     }
     catch(Exception e)
     {
        e.printStackTrace();
     }

    }
}
