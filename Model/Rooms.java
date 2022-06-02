package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Rooms implements Serializable {
    private ArrayList<Room> rooms;

    public Rooms() {
        rooms = new ArrayList<>();
    }

    public Rooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> getAll() {
        return rooms;
    }

    public void remove(Room room) {
        rooms.removeIf(room1 -> room1.equals(room));
    }

    public void add(Room room) {
        rooms.add(room);
    }


    public Room getByNumber(int number) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == number) {
                return room;
            }
        }
        return null;
    }

    public Room get(int index) {
        return rooms.get(index);
    }


    public Rooms copy() {
        return new Rooms(this.rooms);
    }

    public Rooms filter(String roomType) {
        // Creating a copy of the Rooms object with which we will work.
        Rooms filteredList = this.copy();  // 2 time complexities
        // Removing all rooms which do not comply with the given room type.
        filteredList.getAll().removeIf(room -> !room.getRoomType().equals(roomType)); // 3n + 1 time complexities
        return filteredList;    // 1 time complexity
        //O() = 3n + 4 = O(n)
    }

    public Rooms filter(int price) {
        // Creating a copy of the Rooms object with which we will work.
        Rooms filteredList = this.copy();   // 2 time complexities
        // Removing all rooms which do not comply with the given room type.
        filteredList.getAll().removeIf(room -> room.getPrice() > price);    // 3n + 1 time complexities
        return filteredList;    // 1 time complexity
        //O() = 3n + 4 = O(n)
    }


    @Override
    public String toString() {
        return rooms.toString();
    }
}
