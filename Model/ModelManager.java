package Model;

import Utilities.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

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

    public void addRoom(String roomNum, String roomType) {
        getRooms().add(new Room(Integer.parseInt(roomNum), roomType));
    }

    public void removeRoom(String roomNum) {
        getRooms().remove(getRooms().get(Integer.parseInt(roomNum)));
    }


    public Rooms search(Interval interval) {
        Rooms available = getRooms().copy();
        for (Reservation reservation : getReservations().getAll()) {
            if ((!interval.getCheckOutDate().isBefore(reservation.getInterval().getCheckInDate())) || (!reservation.getInterval().getCheckOutDate().isBefore(interval.getCheckInDate()))) {
                available.getAll().removeAll(reservation.getRooms().getAll());
            }
        }
        return available;
    }

    public Rooms filter(Interval interval, String roomType, int price) {
        Rooms available = this.search(interval);
        if (roomType != null) {
            available.filter(roomType);
        }
        if (price != -1) {
            available.filer(price);
        }
        return available;
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
            reservations = (Reservations) MyFileHandler.readFromBinaryFile(roFileName);
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
        }
    }

    // TODO -----------------------------------------------


    public Interval createInterval(String in, String out) {
        int[] arr = Arrays.stream(in.split("/"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dep = Arrays.stream(out.split("/"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new Interval(new Date(arr[0], arr[1], arr[2])
                , new Date(dep[0], dep[1], dep[2]));
    }
}
