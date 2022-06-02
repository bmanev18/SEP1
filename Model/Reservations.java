package Model;

import java.io.Serializable;
import java.util.ArrayList;


public class Reservations implements Serializable {
    private ArrayList<Reservation> reservations;

    public Reservations() {
        reservations = new ArrayList<Reservation>();
    }

    public ArrayList<Reservation> getAll() {
        return reservations;
    }

    public void add(Reservation reservation) {
        reservations.add(reservation);
    }

    public void remove(Reservation reservation) {
        reservations.remove(reservation);
    }

    public Reservation getReservation(int phone) {
        for (Reservation reservation : reservations) {
            if (reservation.getBooker().getPhone() == phone) {
                return reservation;
            }
        }
        return null;
    }

    public String toString() {
        return "List of Reservation {" + "reservations : " + reservations + '}';
    }
}
