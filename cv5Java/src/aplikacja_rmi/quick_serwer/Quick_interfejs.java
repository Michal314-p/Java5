package aplikacja_rmi.quick_serwer;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface Quick_interfejs extends Remote
{
    ArrayList<Integer> rozwiaz(ArrayList<Integer> list, int dane, String nazwa_klienta) throws RemoteException;
}
