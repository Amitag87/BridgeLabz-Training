public class Groceries extends Product implements Taxable {
    
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount
    }
    
    @Override
    public double calculateTax() {
        return price * 0.05; // 5% tax
    }
    
    @Override
    public String getTaxDetails() {
        return "Essential Goods Tax 5%";
    }
}