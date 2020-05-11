package aplikacja_rmi.quick_serwer;

import aplikacja_rmi.algorytmy.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Quick_rmi implements Quick_interfejs
{
    public String opis;
    private String nazwa;
    private Quick_controller controller;

    public Quick_rmi(Quick_controller controller, String opis, String nazwa) throws RemoteException
    {
        this.controller = controller;
        this.opis = opis;
        this.nazwa = nazwa;
    }

    public ArrayList<Integer> rozwiaz(ArrayList<Integer> list, int dane, String nazwa_klienta) throws RemoteException
    {
        ArrayList<Integer> sorted;
        NewQuick quick = new NewQuick();
        sorted = quick.solve1(list);
        controller.pokaz_wiadomosc("Serwer posortowal " + dane + " liczb dla: " + nazwa_klienta);
        return sorted;
    }




}
