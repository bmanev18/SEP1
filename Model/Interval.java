package Model;

public class Interval {
    private Date checkInDate;
    private Date checkOutDate;

    public Interval(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date arrivalDate) {
        this.checkInDate = arrivalDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date departureDate) {
        this.checkOutDate = departureDate;
    }

    public int calculatePeriod() {
        int counter = 0;
        while (!(checkInDate.equals(checkOutDate))) {
            counter++;
            checkInDate.nextDay();
        }
        return counter;
    }

    @Override
    public String toString() {
        return String.format("< %s - %s >", checkInDate, checkOutDate);
    }
}
