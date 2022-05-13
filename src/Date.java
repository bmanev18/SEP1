public class Date {
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

    public boolean isLeapYear()
    {
        if(year%4==0 && year%400==0 || year%4==0 && year%100!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void nextDay()
    {

        day=day+1;
        switch(month)
        {
            case 1:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 3:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 5:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 7:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 8:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 10:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 12:
                if (day==32);
            {
                day=1;
                month=month+1;
            }
            case 4:
                if (day==31)
                {
                    day = 1;
                    month = month + 1;
                }
            case 6:
                if (day==31)
                {
                    day = 1;
                    month = month + 1;
                }
            case 9:
                if (day==31)
                {
                    day = 1;
                    month = month + 1;
                }
            case 11:
                if (day==31)
                {
                    day = 1;
                    month = month + 1;
                }
            case 2:

                if(isLeapYear() ) /* ( (Year%4==0) && (Year%100!=0) ) || ((Year%4==0) && (Year%400==0))*/
                {
                    if (day==30)
                    {
                        day=1;
                        month=month+1;
                    }
                }
                else
                {
                    if (day == 29)
                    {
                        day = 1;
                        month = month + 1;
                    }
                }
        }
        if (month==13)
        {
            year=year+1;
            month=1;
            day=1;
        }

    }

    public Date copy() {
        return new Date( day, month, year);
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Date))
        {
            return false;
        }
        Date other=(Date) obj;
        return other.day==day && other.month==month && other.year==year;
    }

    public String toString() {
        return "Date{" + " day=" + day + ", month=" + month
                + ", year=" + year + '}';
    }
}
