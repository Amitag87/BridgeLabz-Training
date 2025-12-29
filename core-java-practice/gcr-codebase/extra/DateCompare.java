import java.time.LocalDate;
import java.util.Scanner;

class DateCompare {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalDate date1 = LocalDate.parse(scn.next());
        LocalDate date2 = LocalDate.parse(scn.next());

        if (date1.isBefore(date2)) {
            System.out.println("First date is before second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after second date");
        } else {
            System.out.println("Both dates are same");
        }
        scn.close();
    }
}
