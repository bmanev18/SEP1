package GUI;

import Model.ModelManager;
import Model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReservationsController implements Initializable {
    private ModelManager modelManager;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Room> searchTable;
    @FXML
    private TableColumn<Room, String> roomNumber;
    @FXML
    private TableColumn<Room, String> floor;
    @FXML
    private TableColumn<Room, String> type;
    @FXML
    private TableColumn<Room, String> price;
    @FXML
    private TableColumn<Room, String> smoking;
    @FXML
    private DatePicker checkinDate;
    @FXML
    private DatePicker checkOutDate;

    public void goBackwards(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OpeningScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomNumber.setCellValueFactory(new PropertyValueFactory<Room, String>("roomNumber"));
        floor.setCellValueFactory(new PropertyValueFactory<Room, String>("floor"));
        type.setCellValueFactory(new PropertyValueFactory<Room, String>("roomType"));
        price.setCellValueFactory(new PropertyValueFactory<Room, String>("price"));
        smoking.setCellValueFactory(new PropertyValueFactory<Room, String>("smoking"));

        modelManager = new ModelManager("rooms.bin", "rooms.bin");
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(modelManager.getRooms().getAll());
        searchTable.setItems(list);
    }

    public void search(ActionEvent e) {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(
                modelManager.search(modelManager.createInterval(checkinDate.getValue(), checkOutDate.getValue())).getAll());
        searchTable.setItems(list);
    }
}