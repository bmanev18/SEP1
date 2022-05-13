public class DateInterval
{
  private Date checkInDate;
  private Date checkOutDate;

  public  DateInterval(Date checkInDate,Date checkOutDate)
  {
    this.checkInDate=checkInDate;
    this.checkOutDate=checkOutDate;
  }
  
  public Date getCheckInDate()
  {
    return checkInDate;
  }

  public void setCheckInDate(Date arrivalDate)
  {
    this.checkInDate = arrivalDate;
  }

  public Date getCheckOutDate()
  {
    return checkOutDate;
  }

  public void setCheckOutDate(Date departureDate)
  {
    this.checkOutDate = departureDate;
  }

  public int calcP(Date checkInDate,Date checkOutDate)
  {
    int counter=0;
    while(!(checkInDate.equals(checkOutDate)))
    {
      counter++;
      checkInDate.nextDay();
    }
    return counter;
  }

  @Override public String toString()
  {
    return "DateInterval{" + "checkInDate=" + checkInDate + ", checkOutDate="
        + checkOutDate + '}';
  }
}
