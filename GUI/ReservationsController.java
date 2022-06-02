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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReservationsController implements Initializable {
    private ModelManager modelManager;
    private Stage stage;
    private Scene scene;
    private Parent root;

    // ---------- All Reservations ----------
    @FXML
    private ListView<Reservation> reservations;
    @FXML
    private TextField phoneNum;
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
    private ListView<Room> allrooms;
    @FXML
    private ListView<Room> reservedRooms;

    private ObservableList<Integer> selectedIndices;
    private Reservation selected;

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


    public void goBackwards(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OpeningScene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modelManager = new ModelManager("reservations.bin", "rooms.bin");
        updateRes();


        updateAllRooms();
        selectedIndices = allrooms.getSelectionModel().getSelectedIndices();
    }

    public void search(MouseEvent e) {
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(modelManager.search(modelManager.createInterval(checkInDate.getValue(), checkOutDate.getValue())).getAll());
        searchTable.setItems(list);
    }

    public void updateRes() {
        reservations.getItems().clear();
        reservations.getItems().addAll(modelManager.getReservations().getAll());
        phoneNum.clear();
    }

    public void searchPhone(MouseEvent event) {
        reservations.getItems().clear();
        System.out.println("cleared");
        for (Reservation reservation : reservations.getItems()) {
            if (reservation.getBooker().getPhone() == Integer.parseInt(phoneNum.getText())) {
                reservations.getItems().add(reservation);
                System.out.println("added");
                break;
            }
        }
    }

    public void updateAllRooms() {
        allrooms.getItems().addAll(modelManager.getRooms().getAll());
    }

    public void addRoom(MouseEvent event) {
        reservedRooms.getItems().add(allrooms.getItems().get(selectedIndices.get(0)));
    }

    public void deleteRoom(MouseEvent event) {
        reservedRooms.getItems().remove(reservedRooms.getItems().get(selectedIndices.get(0)));
    }


    public void createReservation() {

        String[] date = birthday.getText().split("/");
        Rooms resRooms = new Rooms();
        resRooms.getAll().addAll(reservedRooms.getItems());

        Reservations all = modelManager.getReservations();

        all.add(new Reservation(new Guest(name.getText(), Integer.parseInt(phone.getText()), nationality.getText(), new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])), new Address(street.getText(), Integer.parseInt(post.getText()), city.getText(), country.getText())), resRooms, modelManager.createInterval(checkIn.getValue(), checkOut.getValue()), Integer.parseInt(guestNum.getText())));

        //System.out.println(all.getAll().size());
        modelManager.saveReservations(all);
        updateRes();
    }

    public void filterToday(ActionEvent event) {
        if (today.isSelected()) {
            reservations.getItems().removeIf(reservation -> !reservation.getInterval().getCheckInDate().equals(modelManager.createDate(LocalDate.now())));
        } else {
            updateRes();
        }
    }


    public void removeReservation(ActionEvent event) {
        selected = reservations.getSelectionModel().getSelectedItems().get(0);
        modelManager.removeReservation(reservations.getItems().get(selectedIndices.get(0)));
        updateRes();
    }
}