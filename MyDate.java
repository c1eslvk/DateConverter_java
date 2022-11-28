class MyDate {
    int day;
    int month;
    int year;
    String weekday;

    public MyDate(int day, int month, int year, String weekday) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.weekday = weekday;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getWeekday() {
        return weekday;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        result = prime * result + ((weekday == null) ? 0 : weekday.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyDate other = (MyDate) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        if (weekday == null) {
            if (other.weekday != null)
                return false;
        } else if (!weekday.equals(other.weekday))
            return false;
        return true;
    }
}