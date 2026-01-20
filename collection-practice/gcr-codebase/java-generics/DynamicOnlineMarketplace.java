import java.util.*;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() { return "Books"; }
}

class ClothingCategory implements Category {
    public String getCategoryName() { return "Clothing"; }
}

class GadgetCategory implements Category {
    public String getCategoryName() { return "Gadgets"; }
}

abstract class Product<T extends Category> {
    String name;
    double price;
    T category;
    
    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    abstract void display();
}

class Book extends Product<BookCategory> {
    Book(String name, double price) {
        super(name, price, new BookCategory());
    }
    
    void display() {
        System.out.println("Book: " + name + " - $" + price + " [" + category.getCategoryName() + "]");
    }
}

class Clothing extends Product<ClothingCategory> {
    Clothing(String name, double price) {
        super(name, price, new ClothingCategory());
    }
    
    void display() {
        System.out.println("Clothing: " + name + " - $" + price + " [" + category.getCategoryName() + "]");
    }
}

class Gadget extends Product<GadgetCategory> {
    Gadget(String name, double price) {
        super(name, price, new GadgetCategory());
    }
    
    void display() {
        System.out.println("Gadget: " + name + " - $" + price + " [" + category.getCategoryName() + "]");
    }
}

public class DynamicOnlineMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.price * (percentage / 100);
        product.price -= discount;
        System.out.println("Applied " + percentage + "% discount to " + product.name);
    }
    
    public static void main(String[] args) {
        List<Product<?>> catalog = new ArrayList<>();
        
        Book book = new Book("Java Programming", 50.0);
        Clothing shirt = new Clothing("T-Shirt", 25.0);
        Gadget phone = new Gadget("Smartphone", 800.0);
        
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        
        System.out.println("Original Prices:");
        for (Product<?> product : catalog) {
            product.display();
        }
        
        System.out.println("\\nApplying Discounts:");
        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        applyDiscount(phone, 15);
        
        System.out.println("\\nDiscounted Prices:");
        for (Product<?> product : catalog) {
            product.display();
        }
    }
}