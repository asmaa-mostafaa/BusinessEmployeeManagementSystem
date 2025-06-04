public class Manager extends Employee {
    private double bonus;

    public Manager(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary); // Call to the superclass constructor
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus; // Salary = baseSalary + bonus
    }
}
