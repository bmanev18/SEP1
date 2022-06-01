package GUI;

import Model.*;
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

public class ReservationsController implements Initializable {
    private ModelManager modelManager;
    private Stage stage;
    private Scene scene;
    private Parent root;

    // ---------- All Reservations ----------
    @FXML
    private TableView<Reservation> reservations;
    @FXML
    private TableColumn<Reservation, String> booker;
    @FXML
    private TableColumn<Reservation, String> guestsNum;
    @FXML
    private TableColumn<Reservation, String> rooms;
    @FXML
    private TableColumn<Reservation, String> interval;

    @FXML
    private TextField phoneNum;
    @FXML
    private Button searchPhone;
    @FXML
    private RadioButton today;
    @FXML
    private Button toCheckIn;
    @FXML
    private Button toCheckOut;
    @FXML
    private Button edit;
    @FXML
    private Button delete;

    // ---------- Create Reservation ----------

    @FXML
    private TextField name;
    @FXML
    private TextField nationality;
    @FXML
    private TextField phone;
    @FXML
    private TextField birthday;
    @FXML
    private TextField country;
    @FXML
    private TextField post;
    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private DatePicker checkIn;
    @FXML
    private DatePicker checkOut;
    @FXML
    private TextField guestNum;
    @FXML
    private Button addRoom;
    @FXML
    private Button deleteRoom;
    @FXML
    private ListView<Room> reservedRooms;
    private Rooms resRooms;

    // ---------- Search Rooms ----------

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
    private DatePicker checkInDate;
    @FXML
    private DatePicker checkOutDate;
    @FXML
    private Button search;
    private TableView.TableViewSelectionModel<Room> selectionModel;
    ObservableList<Room> select;


    @FXML
    private ListView<Room> allRooms;


    public void goBackwards(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OpeningScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booker.setCellValueFactory(new PropertyValueFactory<Reservation, String>("booker"));
        guestsNum.setCellValueFactory(new PropertyValueFactory<Reservation, String>("numberExpectedGuests"));
        rooms.setCellValueFactory(new PropertyValueFactory<Reservation, String>("rooms"));
        interval.setCellValueFactory(new PropertyValueFactory<Reservation, String>("interval"));
        resRooms = new Rooms();


        roomNumber.setCellValueFactory(new PropertyValueFactory<Room, String>("roomNumber"));
        floor.setCellValueFactory(new PropertyValueFactory<Room, String>("floor"));
        type.setCellValueFactory(new PropertyValueFactory<Room, String>("roomType"));
        price.setCellValueFactory(new PropertyValueFactory<Room, String>("price"));
        //smoking.setCellValueFactory(new PropertyValueFactory<Room, String>("smoking"));
        selectionModel = searchTable.getSelectionModel();
        select = selectionModel.getSelectedItems();

        modelManager = new ModelManager("reservations.bin", "rooms.bin");
        allRooms = new ListView<>();
        updateAllRooms();
        updateRes();


    }

    public void search(MouseEvent e) {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(
                modelManager.search(modelManager.createInterval(checkInDate.getValue(), checkOutDate.getValue())).getAll());
        searchTable.setItems(list);
    }

    public void updateRes() {
        ObservableList<Reservation> list = FXCollections.observableArrayList();
        list.addAll(modelManager.getReservations().getAll());
        reservations.setItems(list);
    }

    public void updateAllRooms() {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(modelManager.getRooms().getAll());
        allRooms.setItems(list);
    }

    public void getRooms(MouseEvent mouseEvent) {

    }

    public void openAllRooms(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddRooms.fxml"));
            System.out.println(1);
            Parent root1 = fxmlLoader.load();
            System.out.println(2);
            Stage stage = new Stage();
            System.out.println(3);

            stage.setTitle("Add Rooms");

            System.out.println(4);
            stage.setScene(new Scene(root1));

            System.out.println(5);
            stage.show();
        } catch (Exception e) {
            System.out.println("Window doesn't exist");
        }
    }


    /*public void createReservation() {
        String[] date = birthday.getText().split("/");
        modelManager.getReservations().add(new Reservation(new Guest(name.getText(), Integer.parseInt(phone.getText()), nationality.getText(),
                new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                new Address(street.getText(), Integer.parseInt(post.getText()), city.getText(), country.getText())),
                resRooms,
                modelManager.createInterval(checkIn.getValue(), checkOut.getValue()),
                Integer.parseInt(guestNum.getText())));
    }
*/

}