public class SalesPerson extends Employee {
    private double commission;

    public SalesPerson(int id, String name, double baseSalary, double commission) {
        super(id, name, baseSalary); // Call to the superclass constructor
        this.commission = commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + commission; // Salary = baseSalary + commission
    }
}
