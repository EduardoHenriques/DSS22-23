
public class Main {

    public static void main(String args[])
    {
        System.out.println("=====TESTES=====");
        System.out.println("C1 HIBRIDO:");
        C1H carro1 =  new C1H("Mercedes", "Benz", 6000, 410, 0.4f, 150);
        System.out.println(carro1.toString());
        System.out.println("C2:");
        C2 carro2 = new C2("Ford", "GT", 4500, 400, 0.0f, 0.3f, estadoMotor.NULL, tipoPneu.NULL, 0.5f);
        System.out.println(carro2.toString());
        System.out.println("C2 HIBRIDO:");
        C2H carro2H = new C2H("Ferrari", "812GTS", 4200, 310, 0.0f, 0.45f, estadoMotor.NULL, tipoPneu.NULL, 100, 0.5f);
        System.out.println(carro2H.toString());
        System.out.println("GT:");
        GT carro3 = new GT("Bently", "Continental GT-V8", 3000, 450, 0.0f, 0.23f, estadoMotor.NULL, tipoPneu.NULL, 0.10f);
        System.out.println(carro3.toString());
        System.out.println("SC:");
        SC carro4 = new SC("Citroen", "C3", 2500, 275, 0.0f, 0.65f, estadoMotor.NULL, tipoPneu.NULL);  
        System.out.println(carro4.toString());

    }   
}
