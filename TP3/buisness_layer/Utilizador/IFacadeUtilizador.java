package Utilizador;

public interface IFacadeUtilizador {

    public void Registo(String username, String password, boolean isPremium) throws UtilizadorInvalido;

    public Utilizador Login(String username, String password) throws UtilizadorInvalido;

    public Convidado LoginConvidado();

    // APENAS PARA ADMINS -> public void RegistoAdmin(String username, String password) throws UtilizadorInvalido;

}