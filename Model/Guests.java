package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Guests implements Serializable {
    ArrayList<Guest> guests;

    public Guests() {
        guests = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        if (!guests.contains(guest)) {
            guests.add(guest);
        }
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }

    public Guest getGuest(int phone) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getPhone() == phone) {
                return guests.get(i);
            }
        }
        return null;
    }


    public Guest getMainGuest() {
        return guests.get(0);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Guest guest : guests) {
            output.append(guest.toString()).append("\n");
            System.out.println(guest);
        }
        return String.valueOf(output);
    }
}
