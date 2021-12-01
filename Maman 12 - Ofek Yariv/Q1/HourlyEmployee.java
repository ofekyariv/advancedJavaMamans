package maman12a;
public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstname, String lastName, String socialSecurityNumber,double wage, double hours, BirthDate date) {
		super(firstname,lastName, socialSecurityNumber,date);
		
		if(wage<0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		if(hours<0.0 || hours>168.0)
			throw new IllegalArgumentException("Hours worked must be >=0.0 and <=168.0");
		
		this.wage  = wage;
		this.hours = hours;
	}
	
	public void setWage(double wage) {
		if(wage<0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		
		this.wage=wage;
	}
	
	public double getWage() {
		return wage;
	}
	
	public void setHours(double hours) {
		if(hours<0.0 || hours>168.0)
			throw new IllegalArgumentException("Hours worked must be >=0.0 and <=168.0");
		
		this.hours = hours;
	}
	public double getHours() {
		return hours;
	}

	@Override
	public double earnings() {
		if(getHours() <= 40)
			return getWage() * getHours() + getBirthdayBonus();
		else
			return 40 * getWage() + (getHours() - 40) * getWage() *1.5 + getBirthdayBonus();
	}
	
	@Override
	public String toString() {
		return String.format("%s is a hourly employee, his horly wage is: $%,.2f, with %,.2f hours worked",super.toString(), getWage(), getHours());
	}

}
