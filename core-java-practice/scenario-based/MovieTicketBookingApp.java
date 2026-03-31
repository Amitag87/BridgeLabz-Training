package scenariobased;


import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char nextCustomer = 0;

        do {
            int baseTicketPrice = 0;
            int seatPrice = 0;
            int snackPrice = 0;

            System.out.println("\nChoose Movie Type:");
            System.out.println("1. Regular");
            System.out.println("2. 3D");
            System.out.println("3. IMAX");
            int movieType = scanner.nextInt();

            switch (movieType) {
                case 1:
                    baseTicketPrice = 150;
                    break;
                case 2:
                    baseTicketPrice = 220;
                    break;
                case 3:
                    baseTicketPrice = 300;
                    break;
                default:
                    System.out.println("Invalid movie type selected.");
                    continue;
            }

            System.out.print("Choose Seat Type (Gold / Silver): ");
            String seatType = scanner.next();

            if (seatType.equalsIgnoreCase("Gold")) {
                seatPrice = 100;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                seatPrice = 50;
            } else {
                System.out.println("Invalid seat type selected.");
                continue;
            }
            System.out.print("Do you want snacks? (yes / no): ");
            String snacksChoice = scanner.next();

            if (snacksChoice.equalsIgnoreCase("yes")) {
                snackPrice = 80;
            }

            int totalAmount = baseTicketPrice + seatPrice + snackPrice;

            System.out.println("Total Amount to Pay: ₹" + totalAmount);

            System.out.print("\nBook for next customer? (y/n): ");
            nextCustomer = scanner.next().charAt(0);

        } while (nextCustomer == 'y' || nextCustomer == 'Y');

        scanner.close();
        System.out.println("\nThank you for using Movie Ticket Booking App!");
    }
}

