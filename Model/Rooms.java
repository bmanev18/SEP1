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
        rooms.remove(room);
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
        Rooms filteredList = this.copy();
        filteredList.getAll().removeIf(room -> !room.getRoomType().equals(roomType));
        return filteredList;
    }

    public Rooms filer(int price) {
        Rooms filteredList = this.copy();
        filteredList.getAll().removeIf(room -> room.getPrice() > price);
        return filteredList;
    }


    @Override
    public String toString() {
        return rooms.toString();
    }
}
