import java.util.*;

class NoAgentAvailableException extends Exception {
    public NoAgentAvailableException(String message) {
        super(message);
    }
}

class Order {
    private String orderId;
    private double latitude;
    private double longitude;
    
    public Order(String orderId, double latitude, double longitude) {
        this.orderId = orderId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getOrderId() { return orderId; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}

class Agent {
    private String agentId;
    private double latitude;
    private double longitude;
    private boolean available;
    private String currentOrder;
    
    public Agent(String agentId, double latitude, double longitude) {
        this.agentId = agentId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.available = true;
    }
    
    public String getAgentId() { return agentId; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public boolean isAvailable() { return available; }
    public String getCurrentOrder() { return currentOrder; }
    
    public void assignOrder(String orderId) {
        this.available = false;
        this.currentOrder = orderId;
    }
    
    public void completeOrder() {
        this.available = true;
        this.currentOrder = null;
    }
}

class DeliveryService {
    private Queue<Order> orders = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();
    
    public void addOrder(Order order) {
        orders.offer(order);
    }
    
    public void addAgent(Agent agent) {
        agents.add(agent);
    }
    
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
    }
    
    public void assignOrder() throws NoAgentAvailableException {
        if (orders.isEmpty()) return;
        
        Order order = orders.poll();
        Agent nearestAgent = null;
        double minDistance = Double.MAX_VALUE;
        
        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                double distance = calculateDistance(
                    order.getLatitude(), order.getLongitude(),
                    agent.getLatitude(), agent.getLongitude()
                );
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestAgent = agent;
                }
            }
        }
        
        if (nearestAgent == null) {
            orders.offer(order); // Put order back
            throw new NoAgentAvailableException("No agent available for order: " + order.getOrderId());
        }
        
        nearestAgent.assignOrder(order.getOrderId());
        System.out.println("Order " + order.getOrderId() + " assigned to Agent " + nearestAgent.getAgentId());
    }
    
    public void cancelOrder(String orderId) {
        for (Agent agent : agents) {
            if (orderId.equals(agent.getCurrentOrder())) {
                agent.completeOrder();
                System.out.println("Order " + orderId + " cancelled");
                return;
            }
        }
        System.out.println("Order " + orderId + " not found");
    }
    
    public void viewActiveDeliveries() {
        System.out.println("Active Deliveries:");
        for (Agent agent : agents) {
            if (!agent.isAvailable()) {
                System.out.println("Agent " + agent.getAgentId() + " delivering Order " + agent.getCurrentOrder());
            }
        }
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();
        
        // Add agents
        service.addAgent(new Agent("A1", 10.0, 20.0));
        service.addAgent(new Agent("A2", 15.0, 25.0));
        service.addAgent(new Agent("A3", 12.0, 18.0));
        
        // Add orders
        service.addOrder(new Order("O1", 11.0, 19.0));
        service.addOrder(new Order("O2", 16.0, 26.0));
        service.addOrder(new Order("O3", 13.0, 21.0));
        service.addOrder(new Order("O4", 14.0, 22.0));
        
        try {
            service.assignOrder();
            service.assignOrder();
            service.assignOrder();
            service.viewActiveDeliveries();
            
            service.assignOrder(); // Should throw exception
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }
        
        service.cancelOrder("O1");
        service.viewActiveDeliveries();
    }
}