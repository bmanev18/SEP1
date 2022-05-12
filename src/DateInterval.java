public class DateInterval
{
  private Date checkInDate;
  private Date checkOutDate;

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

  @Override public String toString()
  {
    return "DateInterval{" + "checkInDate=" + checkInDate + ", checkOutDate="
        + checkOutDate + '}';
  }
}
