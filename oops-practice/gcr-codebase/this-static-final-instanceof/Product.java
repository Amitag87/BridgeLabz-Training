public class Product {
    private static double discount = 10.0;
    
    private final String productID;
    private String productName;
    private double price;
    private int quantity;
    
    public Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + (price - (price * discount / 100)));
        }
    }
    
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.0, 5, "P001");
        Product product2 = new Product("Smartphone", 800.0, 10, "P002");
        
        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();
    }
}