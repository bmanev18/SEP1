public class Date
{
  private int hour;
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year)
  {
    day = day;
    this.month = month;
    this.year = year;
  }

  public Date(int hour, int day, int month, int year)
  {
    this.hour = hour;
    day = day;
    this.month = month;
    this.year = year;
  }

  public int getHour()
  {
    return hour;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    day = day;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public Date copy()
  {
    return new Date(hour, day, month, year);
  }

  public String toString()
  {
    return "Date{" + "hour=" + hour + ", day=" + day + ", month=" + month
        + ", year=" + year + '}';
  }
}
