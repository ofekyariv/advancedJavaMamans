package maman12a;
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String firstname, String lastName, String socialSecurityNumber, double grossSales, double commissionRate
			,double baseSalary, BirthDate date) {
		super(firstname, lastName, socialSecurityNumber,grossSales, commissionRate, date);
		
		if(baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		this.baseSalary = baseSalary;
	}
	
	public void setBaseSalary(double baseSalary) {
		if(baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}
	
	@Override
	public String toString() {
		return String.format("%s is a base salaried employee, his base salary is: $%,.2f",super.toString(),getBaseSalary());
	}

}
