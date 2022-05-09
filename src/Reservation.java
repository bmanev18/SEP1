public class Reservation
{
  private Guest guest;
  private Room room;
  private Date checkIn;
  private Date checkOut;

  public Reservation(Guest guest, Room room, Date checkIn, Date checkOut)
  {
    this.guest = guest;
    this.room = room;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Room getRoom()
  {
    return room;
  }

  public void setRoom(Room room)
  {
    this.room = room;
  }

  public Date getCheckIn()
  {
    return checkIn;
  }

  public void setCheckIn(Date checkIn)
  {
    this.checkIn = checkIn;
  }

  public Date getCheckOut()
  {
    return checkOut;
  }

  public void setCheckOut(Date checkOut)
  {
    this.checkOut = checkOut;
  }

  public Guest getGuest()
  {
    return guest;
  }

  public void setGuest(Guest guest)
  {
    this.guest = guest;
  }/* ??????*/

  public double getPrice()
  {
    return room.getPrice();/* ??????*/
  }

  public void applyDiscount(double discount)
  {
    discount = getPrice() * 0.10;
  }/* ??????*/

  public String toString()
  {
    return "Reservation{" + "guest=" + guest + ", room=" + room + ", checkIn="
        + checkIn + ", checkOut=" + checkOut + '}';
  }
}
