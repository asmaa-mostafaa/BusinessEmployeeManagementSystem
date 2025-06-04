import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusinessSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new employee");
            System.out.println("2. View all employees");
            System.out.println("3. View total payroll");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new employee
                    System.out.print("Enter employee type (Manager/SalesPerson/Intern): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Base Salary: ");
                    double baseSalary = scanner.nextDouble();

                    if (type.equalsIgnoreCase("Manager")) {
                        System.out.print("Enter Bonus: ");
                        double bonus = scanner.nextDouble();
                        employees.add(new Manager(id, name, baseSalary, bonus));
                    } else if (type.equalsIgnoreCase("SalesPerson")) {
                        System.out.print("Enter Commission: ");
                        double commission = scanner.nextDouble();
                        employees.add(new SalesPerson(id, name, baseSalary, commission));
                    } else if (type.equalsIgnoreCase("Intern")) {
                        employees.add(new Intern(id, name, baseSalary));
                    } else {
                        System.out.println("Invalid employee type.");
                    }
                    break;

                case 2:
                    // View all employees
                    for (Employee emp : employees) {
                        emp.displayInfo();
                        System.out.println("Salary: " + emp.calculateSalary());
                        if (emp instanceof Manager) {
                            System.out.println("Role: Manager");
                        } else if (emp instanceof SalesPerson) {
                            System.out.println("Role: SalesPerson");
                        } else if (emp instanceof Intern) {
                            System.out.println("Role: Intern");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    // View total payroll
                    double totalPayroll = 0;
                    for (Employee emp : employees) {
                        totalPayroll += emp.calculateSalary();
                    }
                    System.out.println("Total Payroll: " + totalPayroll);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
