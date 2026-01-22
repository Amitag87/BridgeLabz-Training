import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        Map<String, Integer> prices = new HashMap<>();
        prices.put("Laptop", 50000);
        prices.put("Phone", 20000);
        prices.put("Headphones", 3000);

        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Phone", prices.get("Phone"));
        cart.put("Laptop", prices.get("Laptop"));
        cart.put("Headphones", prices.get("Headphones"));

        System.out.println("Cart Order:");
        System.out.println(cart);

        TreeMap<Integer, String> sortedByPrice = new TreeMap<>();

        for (String item : cart.keySet()) {
            sortedByPrice.put(cart.get(item), item);
        }

        System.out.println("Items Sorted by Price:");
        System.out.println(sortedByPrice);
    }
}
