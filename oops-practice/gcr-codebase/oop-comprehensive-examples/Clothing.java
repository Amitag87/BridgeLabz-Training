public class Clothing extends Product {
    
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return price * 0.20; // 20% discount
    }
}