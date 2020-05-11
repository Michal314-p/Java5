package aplikacja_rmi.spis;

import aplikacja_rmi.OS;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Spis_interfejs extends Remote
{
    List<OS> getServers() throws RemoteException;
    boolean register(OS serwer) throws RemoteException, NotBoundException;
    int daj_liczbe() throws RemoteException;
    int daj_port() throws RemoteException;

}
