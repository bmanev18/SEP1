package GUI;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller
{

  private Stage stage;
  private Scene scene;
  private Parent root;

  public void switchToManagingRooms(ActionEvent event) throws IOException
  {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ManagingRooms.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToReservations(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Reservations.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}