// Base class for all orders
public class Order {
    protected String orderId;
    protected String orderDate;
    
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    public String getOrderStatus() {
        return "Order Placed";
    }
    
    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId + ", Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}