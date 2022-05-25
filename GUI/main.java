package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    @Override
    public void start(Stage window) throws IOException {
        window.setTitle("Main page");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OpeningScene.fxml"));
        Scene scene = new Scene(loader.load());
        window.setScene(scene);
        window.show(); }
}
