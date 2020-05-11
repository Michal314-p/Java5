package aplikacja_rmi.klienci;

import aplikacja_rmi.counting_serwer.Counting_interfejs;
import aplikacja_rmi.insert_serwer.Insert_interfejs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import aplikacja_rmi.algorytmy.Generuj_liczby;
import aplikacja_rmi.spis.Spis_interfejs;
import aplikacja_rmi.quick_serwer.Quick_interfejs;
import aplikacja_rmi.OS;


import java.io.Serializable;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Klient_controller implements Initializable, Serializable
{

    private static ArrayList<Integer> lista;
    @FXML private TextField ilosc;
    @FXML private TextField minimum;
    @FXML private TextField maximum;
    @FXML private ListView<String> listView;
    @FXML private ChoiceBox<OS> lista_serwerow_box;
    @FXML private Label tytul;
    private static ObservableList<OS> lista_serwerow;
    private Klient_interfejs client;
    private String nazwa_klienta = "Klient ";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


        try {

            Registry registry = LocateRegistry.getRegistry();
            Spis_interfejs central = (Spis_interfejs) registry.lookup("spis");

            int port = central.daj_port();
            int numer = central.daj_liczbe();
            nazwa_klienta = "Klient " + numer;
            tytul.setText(nazwa_klienta);

            lista_serwerow = FXCollections.observableArrayList(central.getServers());
            client = (Klient_interfejs) UnicastRemoteObject.exportObject(new Klient_rmi(this), port);
            registry.bind(nazwa_klienta, client);
        } catch (AlreadyBoundException | NotBoundException | RemoteException ex)
        {
            System.out.println("Centrala nie działa");
        }


    }

    public void wylosuj_liczby()
    {
        lista = (ArrayList<Integer>) Generuj_liczby.losuj_inty(Integer.parseInt(ilosc.getText()), Integer.parseInt(minimum.getText()), Integer.parseInt(maximum.getText()));
    }

    public void pokaz_liczby()
    {
        listView.getItems().clear();
        for(int i = 0; i < lista.size(); i++)
        {
            Integer wyswietl = lista.get(i);
            listView.getItems().add(String.valueOf(wyswietl));
        }
    }

    public void odswiez() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        Spis_interfejs spis = (Spis_interfejs) registry.lookup("spis");
        lista_serwerow = FXCollections.observableArrayList(spis.getServers());
        lista_serwerow_box.setItems(lista_serwerow);
    }

    public void sortuj() throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry();
        Spis_interfejs spis;
        try {
            spis = (Spis_interfejs) registry.lookup("spis");
        } catch (NotBoundException e){
            System.err.println("Spis nie działa");
        }
        String box = String.valueOf(lista_serwerow_box.getSelectionModel().getSelectedItem());
        System.out.println(box);

        if(box.contains("Quick"))
        {
            try {
                Quick_interfejs server = (Quick_interfejs) registry.lookup("Quick");
                lista = server.rozwiaz(lista,Integer.parseInt(ilosc.getText()),nazwa_klienta);
            } catch (NotBoundException e) {
                System.err.println("Wybrany serwer nie istnieje");

            }
        }

        if(box.contains("Counting"))
        {
            try {
                Counting_interfejs ser1 = (Counting_interfejs) registry.lookup("Counting");
                lista = ser1.rozwiaz(lista,Integer.parseInt(ilosc.getText()),nazwa_klienta);
            } catch (NotBoundException e) {
                System.err.println("Wybrany serwer nie istnieje");

            }
        }

        if(box.contains("Insert"))
        {
            try {
                Insert_interfejs ser2 = (Insert_interfejs) registry.lookup("Insert");
                lista = ser2.rozwiaz(lista,Integer.parseInt(ilosc.getText()),nazwa_klienta);
            } catch (NotBoundException e) {
                System.err.println("Wybrany serwer nie istnieje");

            }
        }

        else
        {
            System.out.println("Nic nie wybrano");
        }



    }
}
