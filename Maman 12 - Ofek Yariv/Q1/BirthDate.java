package maman12a;

import java.util.Calendar;

public class BirthDate {
    private int day;
    private int month;
    private int year;

    public BirthDate(int day, int month, int year) {
        Calendar today = java.util.Calendar.getInstance();
        if(day <=0 || month>=13 || year>today.get(Calendar.YEAR))
            throw new IllegalArgumentException("Invalid birth date");
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public BirthDate(BirthDate birthDate) {
        Calendar today = java.util.Calendar.getInstance();
        if(birthDate.getDay() <=0 || birthDate.getMonth()>=13 || birthDate.getYear()>today.get(Calendar.YEAR))
            throw new IllegalArgumentException("Invalid birth date");
        this.day = birthDate.getDay();
        this.month = birthDate.getMonth();
        this.year = birthDate.getYear();
    }

    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    public String toString() {
        return String.format("born at: %s.%s.%s", this.day, this.month, this.year);
    }
}
