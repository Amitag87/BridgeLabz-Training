package scenariobased;
public class EmployeeWageComputation {
    public static void main(String[] args) {

        //starting message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Use Case 1
        int attendence = (int) (Math.random() * 3)-1;
        System.out.println("Attendence: " + attendence);

        // Use Case 2
        int wagePerHour = 20;
        int workingHours = 8;
        int dailyWage = wagePerHour * workingHours;
        System.out.println("Daily Wage: " + dailyWage);

        // Use Case 3
        int partTimeHours = 4;
        int partTimeWage = wagePerHour * partTimeHours;
        System.out.println("Part Time Wage: " + partTimeWage);

        // Use Case 4
        switch(attendence){
            case 0:
                System.out.println("Employee is Absent");
                break;
            case 1:
                System.out.println("Employee is Present Full Time");
                break;
            case 2:
                System.out.println("Employee is Present Part Time");
                break; 
        }

        // Use Case 5
        int totalWorkingDays=20;
        int totalMonthlyWage=0;
        int todayWage = 0;
        for(int day=1;day<=totalWorkingDays;day++){
            attendence = (int) (Math.random() * 3);
            switch(attendence){
                case 0:
                    todayWage=0;
                    break;
                case 1:
                    todayWage=dailyWage;
                    break;
                case 2:
                    todayWage=partTimeWage;
                    break; 
            }
            totalMonthlyWage+=todayWage;
        }
        System.out.println("Total Monthly Wage: " + totalMonthlyWage);

        // Use Case 6
        int maxWorkingHours=100;
        int totalHours=0;
        totalMonthlyWage=0;
        for(int day=1;day<=totalWorkingDays && totalHours<=maxWorkingHours;day++){
            attendence = (int) (Math.random() * 3);
            switch(attendence){
                case 0:
                    todayWage=0;
                    break;
                case 1:
                    todayWage=dailyWage;
                    totalHours+=workingHours;
                    break;
                case 2:
                    todayWage=partTimeWage;
                    totalHours+=partTimeHours;
                    break; 
            }
            totalMonthlyWage+=todayWage;
        }
        System.out.println("Total Monthly Wage with Hours: " + totalMonthlyWage);
    }
}