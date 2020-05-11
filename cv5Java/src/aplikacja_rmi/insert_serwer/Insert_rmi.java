package aplikacja_rmi.insert_serwer;

import aplikacja_rmi.algorytmy.NewCounting;
import aplikacja_rmi.algorytmy.NewInsert;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Insert_rmi implements Insert_interfejs
{
    public String opis;
    private String nazwa;
    private Insert_controller controller;

    public Insert_rmi(Insert_controller controller, String opis, String nazwa) throws RemoteException
    {
        this.controller = controller;
        this.opis = opis;
        this.nazwa = nazwa;
    }

    public ArrayList<Integer> rozwiaz(ArrayList<Integer> list, int dane, String nazwa_klienta) throws RemoteException
    {
        ArrayList<Integer> sorted;
        NewInsert quick = new NewInsert();
        sorted = quick.solve1(list);
        controller.pokaz_wiadomosc("Serwer posortowal " + dane + " liczb dla: " + nazwa_klienta);
        return sorted;
    }




}
