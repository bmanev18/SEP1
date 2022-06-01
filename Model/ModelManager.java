package Model;

import Utilities.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class ModelManager {
    private String reFileName;
    private String roFileName;

    public ModelManager(String reFileName, String roFileName) {
        this.reFileName = reFileName;
        this.roFileName = roFileName;
    }

    // TODO -----------------------------------------------

    public Rooms getRooms() {
        Rooms rooms = new Rooms();

        try {
            rooms = (Rooms) MyFileHandler.readFromBinaryFile(roFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return rooms;
    }

    public void addRoom(String roomNum, String roomType, String price) {
        Rooms rooms = getRooms();
        rooms.add(new Room(Integer.parseInt(roomNum), roomType, Double.parseDouble(price)));
        saveRooms(rooms);
    }

    public void removeRoom(Room room) {
        Rooms rooms = getRooms();
        rooms.remove(room);
        //rooms.getAll().remove(room);
        System.out.println(room);
        saveRooms(rooms);

    }

    public void changeRoom(int index, String number, /*String floor,*/ String type, String price) {
        Rooms rooms = getRooms();
        Room selected = rooms.get(index);
        selected.setNumber(Integer.parseInt(number));
        selected.setFloor(Integer.parseInt(number) / 100);
        selected.setRoomType(type);
        selected.setPrice(Double.parseDouble(price));
        saveRooms(rooms);
    }

    public Rooms search(Interval interval) {
        Rooms available = getRooms().copy();
        for (Reservation reservation : getReservations().getAll()) {
            if ((!interval.getCheckOutDate().isBefore(reservation.getInterval().getCheckInDate()))
                    || (!reservation.getInterval().getCheckOutDate().isBefore(interval.getCheckInDate()))) {
                available.getAll().removeAll(reservation.getRooms().getAll());
            }
        }
        return available;
    }

    public Rooms filter(Interval interval, String roomType, int price) {
        Rooms available = this.search(interval);
        if (price != 0) {
            available.filer(price);
            if (roomType != null) {
                available.filter(roomType);
            }
        }
        return available;
    } //  First return all available rooms for a given Interval and filter if requested


    public Rooms searchToday(LocalDate local) {
        Date today = new Date(local.getDayOfMonth(), local.getMonthValue(), local.getYear());
        Rooms rooms = this.getRooms().copy();
        for (Reservation reservation : getReservations().getAll()) {
            if (!reservation.getInterval().getCheckInDate().equals(today)) {
                rooms.getAll().removeAll(reservation.getRooms().getAll());
            }
        }
        return rooms;
    }

    public void saveRooms(Rooms rooms) {
        try {
            MyFileHandler.writeToBinaryFile(roFileName, rooms);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error writing to file");
        }
    }

    // TODO -----------------------------------------------

    public Reservations getReservations() {
        Reservations reservations = new Reservations();

        try {
            reservations = (Reservations) MyFileHandler.readFromBinaryFile(reFileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return reservations;
    }

    public void saveReservations(Reservations reservations) {
        try {
            MyFileHandler.writeToBinaryFile(reFileName, reservations);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error writing to file");
            e.printStackTrace();
        }
    }

    // TODO -----------------------------------------------

    public Interval createInterval(LocalDate in, LocalDate out) {
        return new Interval(new Date(in.getDayOfMonth(), in.getMonthValue(), in.getYear()),
                new Date(out.getDayOfMonth(), out.getMonthValue(), out.getYear()));
    }


}
