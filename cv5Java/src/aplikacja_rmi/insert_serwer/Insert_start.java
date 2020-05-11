package aplikacja_rmi.insert_serwer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Insert_start extends Application
{
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/aplikacja_rmi/insert_serwer/Insert_projekt.fxml"));
        primaryStage.setTitle("Serwer Insert");
        primaryStage.setScene(new Scene(root, 500, 307));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
