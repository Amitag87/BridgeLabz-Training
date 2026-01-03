// Demo class for restaurant hybrid inheritance
public class RestaurantSystem {
    public static void main(String[] args) {
        System.out.println("=== Restaurant Management (Hybrid Inheritance) ===");
        
        // Both Chef and Waiter inherit from Person and implement Worker
        Chef chef = new Chef("Gordon", 40, "Italian");
        Waiter waiter = new Waiter("Alice", 25, 5);
        
        System.out.println("Chef Information:");
        chef.displayPersonInfo();
        chef.displayRole();
        chef.performDuties();
        System.out.println();
        
        System.out.println("Waiter Information:");
        waiter.displayPersonInfo();
        waiter.displayRole();
        waiter.performDuties();
        System.out.println();
        
        // Demonstrating polymorphism with interface
        Worker[] workers = {chef, waiter};
        System.out.println("All workers performing duties:");
        for (Worker worker : workers) {
            worker.performDuties();
        }
    }
}