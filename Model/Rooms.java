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

    public Room get(int number) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == number) {
                return room;
            }
        }
        return null;
    }

    public Rooms copy() {
        return new Rooms(this.rooms);
    }

    public Rooms filter(String roomType) {
        Rooms filteredList = this.copy();
        for (Room room : filteredList.getAll()) {
            if (!room.getRoomType().equals(roomType)) {
                filteredList.remove(room);
            }
        }
        return filteredList;
    }

    public Rooms filer(int price) {
        Rooms filteredList = this.copy();
        for (Room room : filteredList.getAll()) {
            if (room.getPrice() > price) {
                filteredList.remove(room);
            }
        }
        return filteredList;
    }

    @Override
    public String toString() {
        return rooms.toString();
    }
}
