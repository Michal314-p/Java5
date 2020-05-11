package aplikacja_rmi.spis;


import aplikacja_rmi.OS;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

public class Spis_rmi implements Spis_interfejs
{

    public static Map<String,Integer> serwery = new HashMap<>();
    public static List<OS> lista_serwerow = new ArrayList<>();
    private Spis_controller glowny_spis;
    public int numer = 0;
    public int port = 1004;

    public Spis_rmi(Spis_controller glowny_spis)
    {
        this.glowny_spis = glowny_spis;
        try {
            Spis_interfejs spiss = (Spis_interfejs) UnicastRemoteObject.exportObject(this, 1000);
            LocateRegistry.getRegistry().bind("spis", spiss);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OS> getServers()
    {
        return lista_serwerow;
    }

    public boolean dodaj_serwer(OS server) throws RemoteException, NotBoundException
    {

        lista_serwerow.add(server);
        glowny_spis.pokaz_wiadomosc("Serwer: " + server.getName() + " zarejestrowany");
        glowny_spis.dodaj_serwer(server);
        return true;
    }

    @Override
    public boolean register(OS serwer) throws RemoteException, NotBoundException
    {
        return dodaj_serwer(serwer);
    }

    @Override
    public int daj_liczbe() throws RemoteException {
        numer+=1;
        return numer;
    }

    @Override
    public int daj_port() throws RemoteException {
        port+=1;
        return port;
    }

}
