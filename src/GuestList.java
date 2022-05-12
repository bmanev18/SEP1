import java.util.ArrayList;

public class GuestList {
    ArrayList<Guest> guests;

    public GuestList() {
        guests = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void removeGuest(int phone) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getPhone() == phone) {
                guests.remove(i);
                break;
            }
        }
    }

    public Guest getGuest(int phone) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getPhone() == phone) {
                return guests.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GuestList{" + "guests=" + guests + '}';
    }
    //Auto generated toString only for testing purposes.
}
