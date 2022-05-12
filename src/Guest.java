public class Guest
{
  private String name;
  private String nationality;
  private int phone;
  private int roomNumber;
  private Date birthday;
  private Address address;

  public Guest(String name,int phone,String nationality,int roomNumber,Date birthday,Address address)
  {
    this.name = name;
    this.phone = phone;
    this.nationality = nationality;
    this.roomNumber = roomNumber;
    this.birthday = birthday.copy();
    this.address = address;

  }
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getPhone()
  {
    return phone;
  }

  public void setPhone(int phone)
  {
    this.phone = phone;
  }

  public String getNationality()
  {
    return nationality;
  }

  public void setNationality(String nationality)
  {
    this.nationality = nationality;
  }

  public int getRoomNumber()
  {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber)
  {
    this.roomNumber = roomNumber;
  }
  public Date getBirthday()
  {
    return birthday.copy();
  }
  public void setBirthday(Date birthday)
  {
    this.birthday = birthday.copy();
  }

  public Address getAddress()
  {
    return address;
  }

  public void setAddress(Address address)
  {
    this.address = address;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Guest other))
    {
      return false;
    }
    else return this.getName().equals(other.getName())
            && this.getNationality().equals(other.getNationality())
            && this.getBirthday().equals(other.getBirthday())
            && this.getPhone()==other.getPhone()
            && this.getAddress().equals(other.getAddress())
            && this.getRoomNumber()==(other.getRoomNumber());
  }

  @Override public String toString()
  {
    return "Guest{" + "name='" + name + '\'' + ", phone=" + phone + ", nationality='" + nationality + '\''
        + ", roomNumber='" + roomNumber + '\'' + ", birthday=" + birthday + ", address=" + address + '}';
  }
}
