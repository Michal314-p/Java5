package aplikacja_rmi.spis;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Spis_start extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/aplikacja_rmi/spis/Spis_projekt.fxml"));
        primaryStage.setTitle("Spis");
        primaryStage.setScene(new Scene(root, 375, 450));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
