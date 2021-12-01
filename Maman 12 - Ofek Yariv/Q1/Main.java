package maman12a;
public class Main {
    public static void main(String[] args) {
    	
        BirthDate date1 = new BirthDate(1, 1, 1990);
        BirthDate date2 = new BirthDate(2, 2, 1991);
        BirthDate date3 = new BirthDate(3, 3, 1992);
        BirthDate date4 = new BirthDate(4, 4, 1993);
        BirthDate date5 = new BirthDate(5, 5, 1994);

        SalariedEmployee salariedEmployee = new SalariedEmployee("Ofek", "Yariv", "123-45-6789", 700.00, date1);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Yonatan", "Barak", "987-65-4321", 19.4, 20, date2);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Benjamin", "netaniyahu", "111-22-3333", 300, 0.01, date3);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Miri", "Mesica", "333-22-1111", 4000, 0.02, 200, date4);
        PieceWorker pieceWorkerEmployee = new PieceWorker("Yuval", "Hamebulbal", "125-52-5252", date5, 13);

        Employee[] employees = new Employee[5];
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorkerEmployee;

        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);

            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.12 * employee.getBaseSalary());
                System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }
            System.out.printf("He earned $%,.2f%n%n", currentEmployee.earnings());
        }
    }
}