package aplikacja_rmi.counting_serwer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Counting_start extends Application
{
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/aplikacja_rmi/counting_serwer/Counting_projekt.fxml"));
        primaryStage.setTitle("Serwer Counting");
        primaryStage.setScene(new Scene(root, 500, 307));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
