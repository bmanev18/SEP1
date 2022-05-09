public class Adress
{ private String houseNum;
  private String street;
  private int postNum;
  private String city;
  private String county;

  public Adress(String houseNum, String street, int postNum, String city,
      String county)
  {
    this.houseNum = houseNum;
    this.street = street;
    this.postNum = postNum;
    this.city = city;
    this.county = county;
  }

  public String getHouseNum()
  {
    return houseNum;
  }

  public void setHouseNum(String houseNum)
  {
    this.houseNum = houseNum;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public int getPostNum()
  {
    return postNum;
  }

  public void setPostNum(int postNum)
  {
    this.postNum = postNum;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getCounty()
  {
    return county;
  }

  public void setCounty(String county)
  {
    this.county = county;
  }

 public String toString()
  {
    return "Adress{" + "house number='" + houseNum + '\'' + ", street='" + street
        + '\'' + ", post number=" + postNum + ", city='" + city + '\''
        + ", county='" + county + '\'' + '}';
  }

  public static void main(String[] args)
  {
    Adress ad=new Adress("33A","Knudskovparken",
        4300,"Holbæk","Denmark");
    System.out.println(ad);
  }
}
