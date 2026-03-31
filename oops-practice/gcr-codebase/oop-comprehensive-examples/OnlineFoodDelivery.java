import java.util.ArrayList;
import java.util.List;

public class OnlineFoodDelivery {
    public static void processOrder(List<FoodItem> items) {
        System.out.println("=== Online Food Delivery System ===");
        double totalBill = 0;
        
        for (FoodItem item : items) {
            System.out.println(item.getItemDetails());
            double itemTotal = item.calculateTotalPrice();
            System.out.println("Total Price: $" + itemTotal);
            
            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                double discount = discountable.applyDiscount();
                System.out.println("Discount: $" + discount + " (" + discountable.getDiscountDetails() + ")");
                itemTotal -= discount;
            }
            
            System.out.println("Final Price: $" + itemTotal);
            totalBill += itemTotal;
            System.out.println();
        }
        
        System.out.println("Total Order Amount: $" + totalBill);
    }
    
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Vegetable Curry", 12.0, 2));
        order.add(new NonVegItem("Chicken Biryani", 15.0, 1));
        
        processOrder(order);
    }
}