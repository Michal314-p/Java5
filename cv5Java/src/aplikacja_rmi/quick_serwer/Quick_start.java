package aplikacja_rmi.quick_serwer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Quick_start extends Application
{
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/aplikacja_rmi/quick_serwer/Quick_projekt.fxml"));
        primaryStage.setTitle("Serwer Quick");
        primaryStage.setScene(new Scene(root, 500, 307));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
