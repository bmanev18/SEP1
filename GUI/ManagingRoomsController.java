package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ManagingRoomsController
{

  private Stage stage;
  private Scene scene;
  private Parent root;

  public void goBackwards(ActionEvent event) throws IOException
  {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OpeningScene.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}