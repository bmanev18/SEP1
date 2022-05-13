public class Reservation
{
  private RoomList roomlist;
  private DateInterval dateInterval;
  private GuestList guestList;
  private double price;
  private int numberExpectedGuests;
  private boolean extraBed;

  public Reservation(GuestList guestList, DateInterval dateInterval,
      RoomList roomlist, int numberExpectedGuests)
  {
    this.guestList = guestList;
    this.dateInterval = dateInterval;
    this.roomlist = roomlist;
    this.numberExpectedGuests = numberExpectedGuests;
    for (Room room : this.roomlist.getAllRooms())
    {
      this.price += room.getPrice();
    }

  }

  public RoomList getRoomList()
  {
    return roomlist;
  }

  public DateInterval getDateInterval()
  {
    return dateInterval;
  }

  public void setDateInterval(DateInterval dateInterval)
  {
    this.dateInterval = dateInterval;
  }

  public GuestList getGuestList()
  {
    return guestList;
  }

  public void setGuestList(GuestList guestList)
  {
    this.guestList = guestList;
  }

  public Guest getBooker()
  {
    return guestList.getMainGuest();
  }

  public double getPrice()
  {
    return price;
  }

  public void applyDiscount(int discount)
  {
    this.price = (this.price * discount) / 100;
  }

  public int getNumberExpectedGuests()
  {
    return numberExpectedGuests;
  }

  public void setNumberExpectedGuests(int numeber)
  {
    this.numberExpectedGuests = numeber;
  }

  public double totalPrice()
  {
    return price * dateInterval.calcP(getDateInterval().getCheckInDate(),
        getDateInterval().getCheckOutDate());
  }

   public String toString()
  {
    return "Reservation{" + "roomlist=" + roomlist + ", dateInterval="
        + dateInterval + ", guestList=" + guestList + ", price=" + price
        + ", numberExpectedGuests=" + numberExpectedGuests + ", extraBed="
        + extraBed + '}';
  }
}


