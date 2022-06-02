package Model;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        boolean isLeapYear = false;
        int year = getYear();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0))
            isLeapYear = true;
        return isLeapYear;
    }

    public void nextDay() {
        day++;
        if (day > daysInMonth()) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public int daysInMonth() {
        int days;
        if (month == 2) {
            if (isLeap()) {
                days = 29;
            } else {
                days = 28;
            }
        } else if ((month < 8 && month % 2 == 1) || (month > 7 && month % 2 == 0)) {
            days = 31;
        } else {
            days = 30;
        }
        return days;
    }

    public Date copy() {
        return new Date(day, month, year);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }
        Date other = (Date) obj;
        return other.day == day && other.month == month && other.year == year;
    }

    public boolean isBefore(Date date) {
        if (this.year >= date.year) {   // 4 time complexities
            // if the years are not equal
            if (this.year > date.year) { // 3 time complexities
                return false; // 1 time complexity
            }
            if (this.month >= date.month) {     // 4 time complexity
                // if the months are not equal
                if (this.month > date.month) {  // 3 time complexities
                    return false;   // 1 time complexity
                }
                // return the boolean result of day comparison
                return this.day >= date.day; // 5 time complexities
            }
        }
        return true;    // 1 time complexity
        // O() = 22 = O(1)
    }

    public String toString() {
        return String.format("%d/%2d/%d", day, month, year);
    }

}
