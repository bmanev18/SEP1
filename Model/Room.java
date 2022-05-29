package Model;

import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private int floor;
    private String roomType;
    private double price;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.floor = roomNumber / 100;
        this.roomType = roomType;
        switch (roomType) {
            case ("s1") -> this.price = 259;
            case ("s2") -> this.price = 399;
            case ("s3") -> this.price = 399;
            case ("sb") -> this.price = 129;
            case ("dbk") -> this.price = 169;
            case ("dbt") -> this.price = 169;
        }
    }

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.floor = roomNumber / 100;
        this.roomType = roomType;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        this.floor = roomNumber / 100;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("\n%d - %s : %.2f", roomNumber, roomType, price);
    }
}
