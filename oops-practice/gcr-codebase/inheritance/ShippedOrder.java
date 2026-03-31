// ShippedOrder extends Order (Level 2)
public class ShippedOrder extends Order {
    protected String trackingNumber;
    
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    public String getOrderStatus() {
        return "Shipped";
    }
    
    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}