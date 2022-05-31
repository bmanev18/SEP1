package Model;

import java.io.Serializable;

public class Reservation implements Serializable {
    private Rooms rooms;
    private Interval interval;
    private Guests guests;
    private double pricePerNight;
    private int numberExpectedGuests;
    private boolean extraBed;

    public Reservation(Guest booker, Rooms rooms, Interval interval, int numberExpectedGuests, boolean extraBed) {
        this.guests = new Guests();
        guests.addGuest(booker);
        /* Guests created and a booker is added*/

        this.rooms = rooms;
        this.interval = interval;
        this.pricePerNight = 0;
        setPrice();
        this.numberExpectedGuests = numberExpectedGuests;
        this.extraBed = extraBed;

    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public Guest getBooker() {
        return guests.getMainGuest();
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPrice() {
        for (Room room : this.rooms.getAll()) {
            this.pricePerNight += room.getPrice();
        }
    }

    public void applyDiscount(int discount) {
        this.pricePerNight = (this.pricePerNight * discount) / 100;
    }

    public int getNumberExpectedGuests() {
        return numberExpectedGuests;
    }

    public void setNumberExpectedGuests(int number) {
        this.numberExpectedGuests = number;
    }

    public boolean isExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }

    public double totalPrice() {
        return pricePerNight * interval.calculatePeriod();
    } // When calculating totalPrice a discount will be applied. By default, it is 0%

    public String toString() {
        return "Package.Reservation{" + "rooms=" + rooms +
                ",\n interval=" + interval +
                ",\n guests=" + guests +
                ",\n price=" + pricePerNight +
                ",\n numberExpectedGuests=" + numberExpectedGuests + '}';
    }
}


