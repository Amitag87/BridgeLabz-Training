public class EmployeeWageComputationProblem {
    // UC2, UC3, UC4: Class-level Constants
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAYS = 20;
    public static final int MAX_HRS_IN_MONTH = 100;

    // UC7: Class Method to Compute Employee Wage
    public static int computeEmpWage() {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        // UC6: Calculate wages till condition is reached
        while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
            totalWorkingDays++;
            
            // UC1: Random for attendance check
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            
            // UC4: Switch Case Statement
            int empHrs = switch (empCheck) {
                case IS_FULL_TIME -> 8;  // UC2: Full day hours
                case IS_PART_TIME -> 4;  // UC3: Part time hours
                default -> 0;            // Absent
            };

            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
        }

        // UC5: Calculate monthly wage
        return totalEmpHrs * EMP_RATE_PER_HOUR;
    }

    // UC8: Compute wage with function parameters
    public static int computeEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        System.out.println("\nComputing wage for: " + company);
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            
            int empHrs = switch (empCheck) {
                case IS_FULL_TIME -> 8;
                case IS_PART_TIME -> 4;
                default -> 0;
            };

            totalEmpHrs += empHrs;
        }

        int totalEmpWage = totalEmpHrs * empRatePerHour;
        System.out.println("Total Emp Wage for " + company + ": " + totalEmpWage);
        return totalEmpWage;
    }

    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // UC7: Using Class Method
        int totalWage = computeEmpWage();
        System.out.println("Total Emp Wage: " + totalWage);

        // UC8-UC9: Multiple companies
        computeEmpWage("DMart", 20, 20, 100);
        computeEmpWage("Reliance", 25, 22, 120);
        computeEmpWage("BigBazaar", 18, 18, 90);
    }
}