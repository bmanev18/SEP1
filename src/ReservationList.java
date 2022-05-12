    import java.util.ArrayList;


public class ReservationList{
    private ArrayList<Reservation>reservations;

    public ReservationList (){
        reservations = new ArrayList<Reservation>();
    }

    public void addReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }

    public void removeReservations(int phone) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getBooker().getPhone() == phone)
            {
                reservations.remove(i);
                break;
            }
        }
    }

    public Reservation getReservation(int phone) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getBooker().getPhone() == phone)
            {
                return reservations.get(i);
                break;
            }
        }
        return null;
    }


    public String toString() {
        return "List of Reservation {" + "reservations : " + reservations + '}';
    }

}
