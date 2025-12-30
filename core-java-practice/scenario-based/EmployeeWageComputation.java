public class EmployeeWageComputation {
    public static void main(String[] args) {

        //starting message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Use Case 1
        int attendence = (int) (Math.random() * 3);
        System.out.println("Attendence: " + attendence);
        if(attendence == 0){
            System.out.println("Employee is Absent");
        } else {
            System.out.println("Employee is Present");
        }

        // Use Case 2
        int wagePerHour = 20;
        int workingHours = 8;
        int empAttendenceFull = (int) (Math.random() * 2);
        if(empAttendenceFull == 1){
            int empWage = wagePerHour * workingHours;
            System.out.println("Today's Wage: " + empWage);
        } else {
            System.out.println("Employee is Absent, Today's Wage: 0");
        }

        // Use Case 3
        int partTimeHours = 4;
        int empAttendencePartTime = (int) (Math.random() * 3);
        if(empAttendencePartTime == 1){
            int empWage = wagePerHour * workingHours;
            System.out.println("Employee is Present Full Time, Today's Wage: " + empWage);
        } else if(empAttendencePartTime == 2){
            int empWage = wagePerHour * partTimeHours;
            System.out.println("Employee is Present Part Time, Today's Wage: " + empWage);
        } else {
            System.out.println("Employee is Absent, Today's Wage: 0");
        }

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
                    todayWage=wagePerHour * workingHours;
                    break;
                case 2:
                    todayWage=wagePerHour * partTimeHours;
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
                    todayWage=wagePerHour * workingHours;
                    totalHours+=workingHours;
                    break;
                case 2:
                    todayWage=wagePerHour * partTimeHours;
                    totalHours+=partTimeHours;
                    break; 
            }
            totalMonthlyWage+=todayWage;
        }
        System.out.println("Total Monthly Wage with Hours: " + totalMonthlyWage);
    }
}
