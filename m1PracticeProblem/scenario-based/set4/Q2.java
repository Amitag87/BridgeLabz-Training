import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    abstract String getDetails();
}

class Electronics extends Product {
    int warranty;

    public Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    @Override
    String getDetails() {
        return name + " - Price: " + price + ", Quantity: " + quantity +
               ", Warranty: " + warranty + " months";
    }
}

class Clothing extends Product {
    String size;

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    String getDetails() {
        return name + " - Price: " + price + ", Quantity: " + quantity +
               ", Size: " + size;
    }
}

class Inventory {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added to inventory: " + p.name);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product p : products) {
            System.out.println(p.getDetails());
        }
    }

    public double calculateTotalValue() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalValue();
        }
        return total;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Inventory inventory = new Inventory();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--; // handle blank line
                continue;
            }

            String[] parts = line.split(",\\s*");
            String type = parts[0];

            if (type.equals("Electronics")) {
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                int warranty = Integer.parseInt(parts[4]);

                inventory.addProduct(new Electronics(name, price, quantity, warranty));

            } else if (type.equals("Clothing")) {
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                String size = parts[4];

                inventory.addProduct(new Clothing(name, price, quantity, size));
            }
        }

        inventory.displayInventory();
        System.out.printf("\nTotal value of the inventory: %.2f",
                inventory.calculateTotalValue());
    }
}