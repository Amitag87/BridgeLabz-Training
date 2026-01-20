import java.util.*;

abstract class WarehouseItem {
    String name;
    
    WarehouseItem(String name) {
        this.name = name;
    }
    abstract void display();
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
    
    void display() {
        System.out.println("Electronics: " + name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
    
    void display() {
        System.out.println("Groceries: " + name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
    
    void display() {
        System.out.println("Furniture: " + name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public List<T> getItems() {
        return items;
    }
}

public class SmartWarehouseManagementSystem {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }
    
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));
        
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));
        
        System.out.println("Electronics Storage:");
        displayAllItems(electronicsStorage.getItems());
        
        System.out.println("\nGroceries Storage:");
        displayAllItems(groceriesStorage.getItems());
        
        System.out.println("\nFurniture Storage:");
        displayAllItems(furnitureStorage.getItems());
    }
}

