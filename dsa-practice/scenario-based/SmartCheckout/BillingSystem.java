import java.util.*;
public class Customer{
    String name;
    List<String> items;

    public Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}
public class BillingSystem {
    public static void main(String[] args) {

        Queue<Customer> queue = new LinkedList<>();

        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Milk", 50);
        priceMap.put("Bread", 40);
        priceMap.put("Eggs", 6);

        Map<String, Integer> stockMap = new HashMap<>();
        stockMap.put("Milk", 10);
        stockMap.put("Bread", 5);
        stockMap.put("Eggs", 30);

        queue.add(new Customer("Amit", Arrays.asList("Milk", "Bread")));
        queue.add(new Customer("Neha", Arrays.asList("Eggs", "Milk")));

        while (!queue.isEmpty()) {
            Customer c = queue.poll();
            int bill = 0;

            for (String item : c.items) {
                if (stockMap.get(item) > 0) {
                    bill += priceMap.get(item);
                    stockMap.put(item, stockMap.get(item) - 1);
                }
            }

            System.out.println(c.name + " Bill: ₹" + bill);
        }
    }
}
