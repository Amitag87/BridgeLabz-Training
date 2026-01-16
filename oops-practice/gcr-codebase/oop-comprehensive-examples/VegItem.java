public class VegItem extends FoodItem implements Discountable {
    
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return price * getQuantity();
    }
    
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount on veg items
    }
    
    @Override
    public String getDiscountDetails() {
        return "Vegetarian Discount 10%";
    }
}