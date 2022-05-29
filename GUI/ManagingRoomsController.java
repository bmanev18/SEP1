package GUI;

import Model.ModelManager;
import Model.Room;
import Model.Rooms;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManagingRoomsController implements Initializable {
    private ModelManager modelManager;
    private TableView.TableViewSelectionModel<Room> selectionModel;
    ObservableList<Room> select;
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
    private RadioButton edit;
    @FXML
    private Button save;
    @FXML
    private Button add;


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
        update();
        selectionModel = allRooms.getSelectionModel();
        select = selectionModel.getSelectedItems();

        setUnEditable();


    }

    public void rowClicked(MouseEvent mouseEvent) {
        Room selected = select.get(0);
        roomNumTF.setText(String.valueOf(selected.getRoomNumber()));
        roomFloorTF.setText(String.valueOf(selected.getFloor()));
        roomTypeTF.setText(selected.getRoomType());
        roomPriceTF.setText(String.valueOf(selected.getPrice()));
    }


    public void save(MouseEvent mouseEvent) {
        //System.out.println(selectionModel.getSelectedIndex());
        modelManager.changeRoom(selectionModel.getSelectedIndex(), roomNumTF.getText(), /*roomFloorTF.getText(),*/ roomTypeTF.getText(), roomPriceTF.getText());
        clearTF();
        update();
    }

    public void add(MouseEvent mouseEvent) {
        modelManager.addRoom(roomNumTF.getText(), roomTypeTF.getText(), roomPriceTF.getText());
        clearTF();
        update();
    }

    public void delete() {
        modelManager.removeRoom(selectionModel.getSelectedItem());
        clearTF();
        update();
    }

    public void editable(MouseEvent mouseEvent) {
        //System.out.println(edit.isSelected());
        if (edit.isSelected()) {
            roomNumTF.setEditable(true);
            //roomFloorTF.setEditable(true);
            roomTypeTF.setEditable(true);
            roomPriceTF.setEditable(true);
            save.setDisable(false);
            add.setDisable(false);
        } else {
            setUnEditable();
        }
    }

    public void setUnEditable() {
        roomNumTF.setEditable(false);
        roomFloorTF.setEditable(false);
        roomTypeTF.setEditable(false);
        roomPriceTF.setEditable(false);
        save.setDisable(true);
        add.setDisable(true);
    }

    public void update() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(modelManager.getRooms().getAll());
        allRooms.setItems(list);
    }

    public void clearTF() {
        roomNumTF.clear();
        roomFloorTF.clear();
        roomTypeTF.clear();
        roomPriceTF.clear();
    }
}