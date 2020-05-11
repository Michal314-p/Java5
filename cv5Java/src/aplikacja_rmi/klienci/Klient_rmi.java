package aplikacja_rmi.klienci;

public class Klient_rmi implements Klient_interfejs
{
    Klient_controller controller;
    public Klient_rmi(Klient_controller controller)
    {
        this.controller=controller;
    }
}
