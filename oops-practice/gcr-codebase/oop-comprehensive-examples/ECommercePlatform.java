import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {
    public static void calculateFinalPrices(List<Product> products) {
        System.out.println("=== E-Commerce Platform ===");
        for (Product product : products) {
            System.out.println("Product: " + product.getName());
            System.out.println("Original Price: $" + product.getPrice());
            System.out.println("Discount: $" + product.calculateDiscount());
            if (product instanceof Taxable) {
                Taxable taxable = (Taxable) product;
                System.out.println("Tax: $" + taxable.calculateTax() + " (" + taxable.getTaxDetails() + ")");
            }
            System.out.println("Final Price: $" + product.getFinalPrice());
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("E001", "Laptop", 1000));
        products.add(new Clothing("C001", "T-Shirt", 50));
        products.add(new Groceries("G001", "Rice", 20));
        
        calculateFinalPrices(products);
    }
}