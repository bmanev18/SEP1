package GUI;

import Model.ModelManager;
import Model.Room;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManagingRoomsController implements Initializable {
    private ModelManager modelManager;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Room> allRooms;
    @FXML
    private TableColumn<Room, String> roomNum;
    @FXML
    private TableColumn<Room, String> roomFloor;
    @FXML
    private TableColumn<Room, String> roomType;
    @FXML
    private TableColumn<Room, String> roomPrice;
    @FXML
    private TableColumn<Room, String> smoking;


    @FXML
    private TextField roomNumTF;
    @FXML
    private TextField roomFloorTF;
    @FXML
    private TextField roomTypeTF;
    @FXML
    private TextField roomPriceTF;
    @FXML
    private RadioButton smokingOption;


    public void goBackwards(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OpeningScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomNum.setCellValueFactory(new PropertyValueFactory<Room, String>("roomNumber"));
        roomFloor.setCellValueFactory(new PropertyValueFactory<Room, String>("floor"));
        roomType.setCellValueFactory(new PropertyValueFactory<Room, String>("roomType"));
        roomPrice.setCellValueFactory(new PropertyValueFactory<Room, String>("price"));
        //smoking.setCellValueFactory(new PropertyValueFactory<Room, String>("smoking"));

        modelManager = new ModelManager("reservations.bin", "rooms.bin");
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(modelManager.getRooms().getAll());
        allRooms.setItems(list);
    }
}