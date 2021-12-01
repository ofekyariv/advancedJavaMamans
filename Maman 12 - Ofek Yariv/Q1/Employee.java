package maman12a;
import java.util.Calendar;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private BirthDate birthDate;

    public Employee(String firstname, String lastName, String socialSecurityNumber, BirthDate birthDate) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = new BirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s, social security number: %s, %s", getFirstName(), getLastName(), getSocialSecurityNumber(), birthDate.toString());
    }

    public int getBirthdayBonus() {
        Calendar today = java.util.Calendar.getInstance();
        int month = today.get(Calendar.MONTH) + 1;
        int bonus = 0;
        if (month == this.birthDate.getMonth()) {
            System.out.println("Happy Birthday! Enjoy your 200 NIS bonus ");
            bonus = 200;
        }
        return bonus;
    }

    public abstract double earnings();
}