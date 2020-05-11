package aplikacja_rmi.quick_serwer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import aplikacja_rmi.OS;
import aplikacja_rmi.spis.Spis_interfejs;
import javafx.scene.control.ListView;


import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Quick_controller implements Initializable {
    private Quick_interfejs serwer_inter;
    private String nazwa_algorytmu = "Sortowanie szybkie";
    private OS serwer;
    private static DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    @FXML private ListView aktywnosc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Spis_interfejs spis = (Spis_interfejs) LocateRegistry.getRegistry().lookup("spis");
            int port = 1001;
            String bindingName = "Quick";
            serwer = new OS(bindingName, nazwa_algorytmu);
            serwer_inter = (Quick_interfejs) UnicastRemoteObject.exportObject(new Quick_rmi(this, nazwa_algorytmu, bindingName), port);
            if(spis.register(serwer)) {

                LocateRegistry.getRegistry().bind(bindingName, serwer_inter);
            }
            else{
                System.out.println("Serwer nie może się połączyć z centralą");
            }
        } catch (AlreadyBoundException | NotBoundException | RemoteException ex) {
            System.out.println("Spis nie działa");
        }
    }

    public void pokaz_wiadomosc(String aktywnosc)
    {
        String wiadomosc_string = data.format(LocalDateTime.now()) + "\t" + aktywnosc + "\n";
        this.aktywnosc.getItems().add(wiadomosc_string);
    }

}
