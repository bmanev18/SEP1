public class Room
{
  private int roomNumber;
  private int floor;
  private String roomType;
  private double price;

  public Room(int roomNumber,String roomType)
  {
    this.roomNumber=roomNumber;
    this.floor=roomNumber/100;
    this.roomType=roomType;
    switch (roomType)
    {
      case ("s1") -> this.price = 259;
      case ("s2"), ("s3") -> this.price = 399;
      case ("sb") -> this.price = 129;
      case ("dbk"), ("dbt") -> this.price = 169;
    }
  }

  public int getRoomNumber()
  {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber)
  {
    this.roomNumber = roomNumber;
    this.floor=roomNumber/100;
  }

  public int getFloor()
  {
    return floor;
  }

  public void setFloor(int floor)
  {
    this.floor = floor;
  }

  public String getRoomType()
  {
    return roomType;
  }

  public void setRoomType(String roomType)
  {
    this.roomType = roomType;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public double getPrice()
  {
    return price;
  }

  @Override public String toString()
  {
    return "Room{" + "roomNumber=" + roomNumber + ", floor=" + floor
        + ", roomType='" + roomType + '\'' + ", price=" + price + '}';
  }
}
