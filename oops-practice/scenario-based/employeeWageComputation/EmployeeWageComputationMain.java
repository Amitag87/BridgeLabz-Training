public class EmployeeWageComputationMain {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // UC9-UC13: Multiple companies with EmpWageBuilder
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();

        // UC10: Add multiple companies
        empWageBuilder.addCompanyEmpWage("DMart", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Reliance", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("BigBazaar", 18, 18, 90);

        // UC11-UC12: Compute wages using interface approach
        empWageBuilder.computeEmpWage();

        // UC14: Query total wage by company
        System.out.println("\nQuerying Total Wage:");
        System.out.println("Total Wage for DMart: " + empWageBuilder.getTotalWage("DMart"));
        System.out.println("Total Wage for Reliance: " + empWageBuilder.getTotalWage("Reliance"));
    }
}
