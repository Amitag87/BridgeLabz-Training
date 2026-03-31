import java.time.LocalDate;
import java.util.Scanner;

class DateArithmetic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scn.next());
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Final Date " + result);
        scn.close();
    }
}
