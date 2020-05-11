package aplikacja_rmi.counting_serwer;

import aplikacja_rmi.algorytmy.NewCounting;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Counting_rmi implements Counting_interfejs
{
    public String opis;
    private String nazwa;
    private Counting_controller controller;

    public Counting_rmi(Counting_controller controller, String opis, String nazwa) throws RemoteException
    {
        this.controller = controller;
        this.opis = opis;
        this.nazwa = nazwa;
    }

    public ArrayList<Integer> rozwiaz(ArrayList<Integer> list, int dane, String nazwa_klienta) throws RemoteException
    {
        ArrayList<Integer> sorted;
        NewCounting quick = new NewCounting();
        sorted = quick.solve1(list);
        controller.pokaz_wiadomosc("Serwer posortowal " + dane + " liczb dla: " + nazwa_klienta);
        return sorted;
    }




}
