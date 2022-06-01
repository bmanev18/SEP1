package Model;

import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private int postNum;
    private String city;
    private String county;

    public Address(String street, int postNum, String city,
                   String county) {
        this.street = street;
        this.postNum = postNum;
        this.city = city;
        this.county = county;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String toString() {
        return "Address{" + " street='" + street
                + '\'' + ", post number=" + postNum + ", city='" + city + '\''
                + ", county='" + county + '\'' + '}';
    }
}
