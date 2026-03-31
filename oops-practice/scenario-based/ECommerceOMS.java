public class ECommerceOMS {
    public static void main(String[] args) {
        Customer c1=new Customer("johnny", "johnny@gmail.com", "delhi");
        System.out.println("Name of customer1 "+c1.getName());
        Order o1=new Order("O102", "O12", 2);
        o1.displayOrderDetails();
        Payment p1=new CardPayment();
        try {
            p1.pay(1000);
            System.out.println("Order Placed Successfullyy");
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
class PaymentFailedException extends Exception{
    public PaymentFailedException(String message){
        super(message);
    }
}
class Customer{
    private String name;
    private String email;
    private String address;
    public Customer(String name,String email,String address){
        this.name=name;
        this.email=email;
        this.address=address;
    }
     String getName(){
        return name;
    }
}
class Order{
    private String orderId;
    private String productId;
    private int quantity;
    public Order(String orderId, String productId, int quantity){
        this.orderId=orderId;
        this.productId=productId;
        this.quantity=quantity;
    }
    void displayOrderDetails(){
        System.out.println("Order ID: "+orderId);
        System.out.println("Product ID: "+productId);
        System.out.println("Quantity: "+quantity);
    }
}
class Product{
    public String name;
    public String productId;
    public double price;
    public Product(String name, String productId, double price){
        this.name=name;
        this.productId=productId;
        this.price=price;
    } 
}
interface Payment{
    void pay(double amount) throws PaymentFailedException;
}
class CardPayment implements Payment{
    public void pay(double amount) throws PaymentFailedException{
        if (amount <= 0) {
            throw new PaymentFailedException("Invalid payment amount");
        }
        System.out.println("Payment of $" + amount + " processed successfully");
    }
}
class UPIPayment implements Payment{
    public void pay(double amount) throws PaymentFailedException{
        if (amount <= 0) {
            throw new PaymentFailedException("Invalid payment amount");
        }
        System.out.println("Payment of $" + amount + " processed successfully via UPI");
    }
}
class WalletPayment implements Payment{
    public void pay(double amount) throws PaymentFailedException{
        if (amount <= 0) {
            throw new PaymentFailedException("Invalid payment amount");
        }
        System.out.println("Payment of $" + amount + " processed successfully via Wallet");
    }
}