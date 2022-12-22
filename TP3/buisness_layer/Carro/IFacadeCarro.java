package Carro;

public interface IFacadeCarro {

    public Carro findCarro(String modelo) throws CarroInvalido;

    public String garagemToString();

    public boolean addCarro(Carro c);

}