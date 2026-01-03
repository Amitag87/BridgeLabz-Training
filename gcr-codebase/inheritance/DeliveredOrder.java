// DeliveredOrder extends ShippedOrder (Level 3)
public class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String getOrderStatus() {
        return "Delivered";
    }
    
    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}