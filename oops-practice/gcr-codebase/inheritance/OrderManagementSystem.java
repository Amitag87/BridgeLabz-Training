// Demo class for multilevel inheritance
public class OrderManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Online Retail Order Management ===");
        
        // Level 1: Basic Order
        Order order1 = new Order("ORD001", "2024-01-15");
        System.out.println("Basic Order:");
        order1.displayOrderInfo();
        System.out.println();
        
        // Level 2: Shipped Order
        ShippedOrder order2 = new ShippedOrder("ORD002", "2024-01-16", "TRK12345");
        System.out.println("Shipped Order:");
        order2.displayOrderInfo();
        System.out.println();
        
        // Level 3: Delivered Order
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2024-01-17", "TRK67890", "2024-01-20");
        System.out.println("Delivered Order:");
        order3.displayOrderInfo();
    }
}