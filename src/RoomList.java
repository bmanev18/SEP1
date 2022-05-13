import java.util.ArrayList;

public class RoomList {
  private ArrayList<Room> rooms;

  public RoomList() {
    rooms = new ArrayList<>();
  }

  public void addRoom(Room room) {
    rooms.add(room);
  }

  public void removeRoom(Room room) {
    rooms.remove(room);
  }

  public ArrayList<Room> getAllRooms()
  {
    return rooms;
  }

  public Room getRoom(int number) {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i).getRoomNumber() == number) {
        return rooms.get(i);
      }
    }
    return null;
  }

}
