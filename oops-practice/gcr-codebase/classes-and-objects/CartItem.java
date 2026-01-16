public class CartItem {
    String itemName;
    double price;
    int quantity;
    
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
    
    public void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }
    
    public void removeItem(int qty) {
        if (quantity >= qty) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        }
    }
    
    public void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + String.format("%.2f", total));
    }
    
    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 999.99, 1);
        item.addItem(2);
        item.removeItem(1);
        item.displayTotalCost();
    }
}