package maman12a;
public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstname, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, BirthDate date) {
		super(firstname, lastName, socialSecurityNumber, date);
		
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commisiion rate must be >0.0 and <1.0");
		
		if(grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >0.0");
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	public void setGrossSales(double grossSales) {
		if(grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >0.0");
		
		this.grossSales = grossSales;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	
	public void setCommissionRate(double commissionRate) {
		if(commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commisiion rate must be >0.0 and <1.0");
		
		this.commissionRate = commissionRate;
	}
	
	public double getcommissionRate() {
		return commissionRate;
	}
	
	@Override
	public double earnings() {
		return getcommissionRate() * getGrossSales() + getBirthdayBonus();
	}
	
	@Override
	public String toString() {
		return String.format("%s is a commission employee, his gross sales are: $%,.2f with %,.2f commission rate",super.toString(),getGrossSales(),getcommissionRate());
	}

}
