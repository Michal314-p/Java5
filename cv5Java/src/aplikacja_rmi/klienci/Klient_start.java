package aplikacja_rmi.klienci;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Klient_start extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/aplikacja_rmi/klienci/Klient_projekt.fxml"));
        primaryStage.setTitle("Klient");
        primaryStage.setScene(new Scene(root, 375, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
