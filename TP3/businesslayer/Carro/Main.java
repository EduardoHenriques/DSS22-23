
public class Main {

    public static void main(String args[])
    {
        try {
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

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }   
}
