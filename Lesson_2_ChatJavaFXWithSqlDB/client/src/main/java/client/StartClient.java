package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Chat JavaFX");
        primaryStage.setScene(new Scene(root, 450, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
