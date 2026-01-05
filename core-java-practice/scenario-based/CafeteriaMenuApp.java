import java.util.Scanner;

public class CafeteriaMenuApp {
    private static String[] menuItems = {
        "Burger", "Pizza", "Sandwich", "Pasta", "Salad",
        "Coffee", "Tea", "Juice", "Ice Cream", "Cake"
    };
    
    private static double[] prices = {
        150.0, 250.0, 100.0, 200.0, 120.0,
        50.0, 30.0, 80.0, 90.0, 110.0
    };
    
    public static void displayMenu() {
        System.out.println("=== Campus Cafeteria Menu ===");
        System.out.println("Index | Item        | Price (INR)");
        System.out.println("------|-------------|------------");
        
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%-5d | %-11s | %.2f%n", i, menuItems[i], prices[i]);
        }
        System.out.println();
    }
    
    public static String getItemByIndex(int index) {
        if (index >= 0 && index < menuItems.length) {
            return menuItems[index];
        }
        return "Invalid item";
    }
    
    public static double getPriceByIndex(int index) {
        if (index >= 0 && index < prices.length) {
            return prices[index];
        }
        return 0.0;
    }
    
    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0;
        
        System.out.println("Enter item indices to order (enter -1 to finish):");
        
        while (true) {
            System.out.print("Select item index: ");
            int choice = scanner.nextInt();
            
            if (choice == -1) {
                break;
            }
            
            if (choice >= 0 && choice < menuItems.length) {
                String item = getItemByIndex(choice);
                double price = getPriceByIndex(choice);
                totalBill += price;
                
                System.out.println("Added: " + item + " - " + price + " INR");
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        
        System.out.println("\n=== Order Summary ===");
        System.out.println("Total Bill: " + totalBill + " INR");
    }
    
    public static void main(String[] args) {
        displayMenu();
        takeOrder();
    }
}