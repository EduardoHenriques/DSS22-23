package Carro;
import java.util.*;


public class FacadeCarro implements IFacadeCarro {

    private HashMap<String,Carro> mapCarros = new HashMap<String,Carro>();   //modelo(key) -> carro

    public HashMap<String,Carro> getGaragem()
    {
        return this.mapCarros;
    }

    public Carro findCarro(String modelo) throws CarroInvalido
    {
        if(!this.mapCarros.containsKey(modelo)) throw new CarroInvalido("Nao existe carro com esse modelo");
        else 
        {
            Carro c = this.mapCarros.get(modelo);    
            String tipoCarro = c.getClass().getSimpleName();
            switch(tipoCarro)
            {
                case "C1":
                    C1 new_c1  = (C1) c;
                    return new_c1.clone();
                case "C1H":
                    C1H new_c1h = (C1H) c;
                    return new_c1h.clone();
                case "C2":
                    C2 new_c2 = (C2) c;
                    return new_c2.clone();
                case "C2H":
                    C2H new_c2h = (C2H) c;
                    return new_c2h.clone();
                case "GT":
                    GT new_gt = (GT) c;
                    return new_gt.clone();
                case "GTH":
                    GTH new_gth = (GTH) c;
                    return new_gth.clone();
                case "SC":
                    SC new_sc = (SC) c;
                    return new_sc.clone();
                default:
                    throw new CarroInvalido("Erro a retirar o carro da garagem, tipo de carro inválido");
            }
        }
    }

    public boolean addCarro(Carro c)
    {
        String key = c.getModelo();
        if(this.getGaragem().containsKey(key))
            return false;
        else
            {
                this.getGaragem().put(key,c);
                return true;
            }
    }

    public String garagemToString()
    {
        String s = "====================\nGARAGEM DO SIMULADOR\n====================\n\n";
        for(Map.Entry<String,Carro> pair : this.mapCarros.entrySet())
                s += pair.getValue().toString();
        return s;

    }




}