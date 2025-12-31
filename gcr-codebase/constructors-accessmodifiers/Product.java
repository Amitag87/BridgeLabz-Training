public class Product {
    String productName;
    double price;
    static int totalProducts = 0;
    
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    
    public void displayProductDetails() {
        System.out.println("Product: " + productName + ", Price: $" + price);
    }
    
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
    
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 999.99);
        Product p2 = new Product("Mouse", 25.50);
        
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}