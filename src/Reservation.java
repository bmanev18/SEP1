public class Reservation {
    private RoomList roomList;
    private DateInterval dateInterval;
    private GuestList guestList;
    private double price;
    private int numberExpectedGuests;
    private boolean extraBed;


    public Reservation(GuestList guestList, DateInterval dateInterval, RoomList roomList,
                       int numberExpectedGuests) {
        this.guestList = guestList;
        this.dateInterval = dateInterval;
        this.roomList = roomList;
        this.numberExpectedGuests = numberExpectedGuests;
        for (Room room : this.roomList.getAllRooms()) {
            this.price += room.getPrice();
        }

    }

    public RoomList getRoomList() {
        return roomList;
    }

    public void setRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    public DateInterval getDateInterval() {
        return dateInterval;
    }

    public void setDateInterval(DateInterval dateInterval) {
        this.dateInterval = dateInterval;
    }

    public GuestList getGuestList() {
        return guestList;
    }

    public void setGuestList(GuestList guestList){
        this.guestList = guestList;
    }

    public Guest getBooker() {
        return this.guestList.getMainGuest();
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(int discount) {
        this.price = (this.price * discount) / 100;
    }

    public int getNumberExpectedGuests() {
        return numberExpectedGuests;
    }

    public void setNumberExpectedGuests(int number) {
        this.numberExpectedGuests = number;
    }


    @Override
    public String toString() {
        return "Reservation{" + "roomList=" + roomList + ", dateInterval="
                + dateInterval + ", guestList=" + guestList + ", price=" + price
                + ", numberExpectedGuests=" + numberExpectedGuests + ", extraBed="
                + extraBed + '}';
    }
}
