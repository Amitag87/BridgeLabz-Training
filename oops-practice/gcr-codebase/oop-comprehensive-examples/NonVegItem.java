public class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge = 2.0; // $2 extra for non-veg
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return (price + additionalCharge) * getQuantity();
    }
    
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount on non-veg items
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-Vegetarian Discount 5%";
    }
}