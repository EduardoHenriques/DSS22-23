package Racing;
import Carro.tipoPneu;
import Utilizador.*;
import Carro.*;
import java.util.*;

public class Main {
    public static void main (String args[])
    {
     try
     {

        ArrayList<Seccao> lista_seccoes = new ArrayList<>();
        lista_seccoes.add(new Seccao(0,4));
        lista_seccoes.add(new Seccao(1,4));
        lista_seccoes.add(new Seccao(1,4));
        lista_seccoes.add(new Seccao(1,4));
        lista_seccoes.add(new Seccao(2,5));
        lista_seccoes.add(new Seccao(2,4));
        Circuito circuito = new Circuito("corrida_teste", 6, 7, lista_seccoes);

        //participante 1
        Utilizador j = new Jogador("eu","123",0,false);
        Carro c = new SC("Mercedes-Benz","A-220",2500,600,0.74f);
        Piloto p = new Piloto("Joaquim",0.2f,0.7f);
        Participante part = new Participante(j,p,c);
        System.out.println(part.toString());
        //participante 2
        Utilizador j2 = new Jogador("Manuela","banana",0,false);
        Carro c2 = new C1("Bugatti","Bolide",6000,800,0.12f);
        Piloto p2 = new Piloto("Manel",0.5f,0.2f);
        Participante part2 = new Participante(j2,p2,c2);
        System.out.println(part2.toString());
         //participante 2
         Utilizador j3 = new Jogador("JoJo",";_;",0,false);
         Carro c3 = new GT("Lexus","LC 500 Coupe",4000,750,0.32f);
         Piloto p3 = new Piloto("Joaquim",0.2f,0.7f);
         Participante part3 = new Participante(j3,p3,c3);
         System.out.println(part3.toString());
         
         ArrayList<Participante> participantes = new ArrayList<>();
         participantes.add(part);
         participantes.add(part2);
         participantes.add(part3);

         Corrida corrida = new Corrida(circuito, 0, participantes);
         corrida.vaiUlt(part3);
         HashSet<Map.Entry<Circuito,Boolean>> circuitos = new HashSet<>();
         Map.Entry<Circuito,Boolean> entry =
            new AbstractMap.SimpleEntry<Circuito,Boolean>(circuito, false);
         circuitos.add(entry);
         
         Campeonato campeonato = new Campeonato(circuitos,"campeonato1");
         campeonato.addParticipante(part);
         campeonato.addParticipante(part2);
         campeonato.addParticipante(part3);
         
         System.out.println(campeonato.simulaProximaCorrida(circuito));
     }
     catch(Exception e)
     {
        e.printStackTrace();
     }
    }
}
