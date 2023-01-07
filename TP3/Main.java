import java.util.*;

import buisness.Racing.*;
import buisness.Utilizador.*;
import buisness.Carro.*;
import ui.*;

public class Main {

    public static void main(String args[])
    {
        try {
            Map <String, Circuito> circuitos = new HashMap<>();
            Circuito circuito1 = new Circuito();
            circuito1.createCircuito("Portimao", 1000, 10, 4, 1);
            System.out.println(circuito1.toString());
            circuitos.put("Portimao", circuito1);
            System.out.println("=====TESTES=====");
            System.out.println("C1 HIBRIDO:");
            C1H carro1 =  new C1H("Mercedes", "Benz", 6000, 410, 0.4f, 150);
            System.out.println(carro1.toString());
            System.out.println("C2:");
            C2 carro2 = new C2("Ford", "GT", 4500, 400,0.2f);
            System.out.println(carro2.toString());
            GT carro3 = new GT("a tua mae","de 4",3000,500,0.25f);
            System.out.println(carro3.toString());
            SC carro4 = new SC("zeca","guei",2500,475,0.45f);
            System.out.println(carro4.toString());
            FacadeCarro fC = new FacadeCarro();
            System.out.println(fC.addCarro(carro2));
            System.out.println(fC.addCarro(carro3));
            System.out.println(fC.addCarro(carro1));
            System.out.println(fC.garagemToString());

            System.out.println("\n\n\nTAMBORES...\n\n\n");
            System.out.println(fC.findCarro("GT").toString());



        } 
        catch (Exception e) {
            e.printStackTrace();
        }

    }   
}