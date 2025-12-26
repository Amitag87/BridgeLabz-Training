import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalDistance = 0.0;
        String choice = "no";

        while (!choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter distance covered till next stop (in km): ");
            double distance = sc.nextDouble();
            totalDistance += distance;

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            choice = sc.next();
        }

        System.out.println("Total distance traveled: " + totalDistance + " km");
        sc.close();
    }
}
