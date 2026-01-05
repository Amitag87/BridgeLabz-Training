public abstract class Product {
    private String productId;
    private String name;
    protected double price;
    
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public abstract double calculateDiscount();
    
    public double getFinalPrice() {
        double tax = 0;
        if (this instanceof Taxable) {
            tax = ((Taxable) this).calculateTax();
        }
        return price + tax - calculateDiscount();
    }
    
    // Getters and Setters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}