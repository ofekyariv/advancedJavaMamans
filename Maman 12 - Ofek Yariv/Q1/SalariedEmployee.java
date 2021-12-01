package maman12a;
public class SalariedEmployee extends Employee {
	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary, BirthDate date) {
		super(firstName, lastName,socialSecurityNumber, date);
		
		if(weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		
		this.weeklySalary = weeklySalary;
	}
	
	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		
		this.weeklySalary = weeklySalary;
	}
	
	public double getWeeklySalary() {
		return this.weeklySalary;
	}
	
	@Override
	public double earnings() {
		return getWeeklySalary() + getBirthdayBonus();
	}
	
	@Override
	public String toString() {
		return String.format("%s is a salaried employee. his weekly salary is: $%,.2f", super.toString(), getWeeklySalary());
	}
}
