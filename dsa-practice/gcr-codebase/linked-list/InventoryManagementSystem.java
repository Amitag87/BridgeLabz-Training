class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;
    
    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private ItemNode head;
    
    public void addItem(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void removeItem(int itemId) {
        if (head == null) return;
        
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        
        ItemNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found");
    }
    
    public ItemNode searchById(int itemId) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public ItemNode searchByName(String itemName) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public double calculateTotalValue() {
        double total = 0;
        ItemNode current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        return total;
    }
    
    public void sortByName() {
        if (head == null || head.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            
            while (current.next != null) {
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    // Swap data
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;
                    
                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;
                    
                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;
                    
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    
    public void displayInventory() {
        System.out.println("=== Inventory ===");
        ItemNode current = head;
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName + 
                             ", Quantity: " + current.quantity + ", Price: $" + current.price);
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + calculateTotalValue());
    }
    
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        ims.addItem("Laptop", 101, 10, 999.99);
        ims.addItem("Mouse", 102, 50, 25.50);
        ims.addItem("Keyboard", 103, 30, 75.00);
        
        ims.displayInventory();
        
        ims.updateQuantity(102, 45);
        ims.sortByName();
        
        System.out.println("\nAfter updates and sorting:");
        ims.displayInventory();
    }
}