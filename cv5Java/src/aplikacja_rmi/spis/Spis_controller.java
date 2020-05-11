package aplikacja_rmi.spis;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import aplikacja_rmi.OS;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Spis_controller implements Initializable
{

    Spis_interfejs central;
    private static DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private List<OS> lista_serwerow = new ArrayList<>();


    @FXML private ListView wiadomosc;
    @FXML private ListView serwery;
    private static String wiadomosc_string ="";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (RemoteException e)
        {
            e.printStackTrace();
        }
        Spis_rmi spisrmi = new Spis_rmi(this);
        wiadomosc.setEditable(false);
    }

    public void dodaj_serwer(OS nowy_serwer)
    {
        lista_serwerow.add(nowy_serwer);
        serwery.setItems(FXCollections.observableArrayList(lista_serwerow));
    }


    public void pokaz_wiadomosc(String wiadomosc)
    {
        this.wiadomosc.getItems().clear();
        wiadomosc_string += data.format(LocalDateTime.now()) + "\t" + wiadomosc+"\n";
        this.wiadomosc.getItems().add(String.valueOf(wiadomosc_string));
    }

}
