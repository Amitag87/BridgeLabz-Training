package scenariobased;

import java.util.Scanner;

public class LibraryFineCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int finePerDay = 5;
        int totalFine = 0;

        for (int bookCount = 1; bookCount <= 5; bookCount++) {

            System.out.println("\nBook " + bookCount);

            System.out.print("Enter due date (day number): ");
            int dueDate = scanner.nextInt();

            System.out.print("Enter return date (day number): ");
            int returnDate = scanner.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * finePerDay;
                totalFine += fine;

                System.out.println("Late by " + lateDays + " days");
                System.out.println("Fine for this book: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }

        System.out.println("\nTotal Fine for all books: ₹" + totalFine);

        scanner.close();
    }
}
