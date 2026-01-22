import java.util.*;

class VotingSystem {
    private HashMap<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    
    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        System.out.println("Vote cast for: " + candidate);
    }
    
    public void displayResults() {
        System.out.println("\\n=== Voting Results ===");
        System.out.println("Vote order: " + voteOrder);
        
        TreeMap<String, Integer> sortedResults = new TreeMap<>(votes);
        System.out.println("Sorted results: " + sortedResults);
        
        String winner = votes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No winner");
        System.out.println("Winner: " + winner + " with " + votes.get(winner) + " votes");
    }
}

class ShoppingCart {
    private HashMap<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
    
    public ShoppingCart() {
        productPrices.put("Laptop", 50000.0);
        productPrices.put("Mouse", 500.0);
        productPrices.put("Keyboard", 1500.0);
        productPrices.put("Monitor", 15000.0);
    }
    
    public void addItem(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            System.out.println("Added " + quantity + " " + product + "(s) to cart");
        } else {
            System.out.println("Product not available: " + product);
        }
    }
    
    public void displayCart() {
        System.out.println("\\n=== Shopping Cart ===");
        System.out.println("Items (insertion order): " + cartItems);
        
        TreeMap<String, Double> sortedByPrice = new TreeMap<>();
        for (String item : cartItems.keySet()) {
            sortedByPrice.put(item, productPrices.get(item));
        }
        System.out.println("Items sorted by price: " + sortedByPrice);
        
        double total = cartItems.entrySet().stream()
                .mapToDouble(entry -> productPrices.get(entry.getKey()) * entry.getValue())
                .sum();
        System.out.println("Total: ₹" + total);
    }
}
class BankingSystem {
    private HashMap<String, Double> accounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();
    
    public void createAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        System.out.println("Account " + accountNumber + " created with balance: ₹" + balance);
    }
    
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
            System.out.println("Withdrawal request queued for: " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
    
    public void processWithdrawals() {
        System.out.println("\\n=== Processing Withdrawals ===");
        while (!withdrawalQueue.isEmpty()) {
            String account = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for: " + account + " (Balance: ₹" + accounts.get(account) + ")");
        }
    }
    
    public void displayAccountsByBalance() {
        System.out.println("\\n=== Accounts Sorted by Balance ===");
        TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>(Collections.reverseOrder());
        
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedByBalance.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            System.out.println("Balance ₹" + entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class ComprehensiveCollectionSystems {
    public static void main(String[] args) {
       
        System.out.println("=== VOTING SYSTEM ===");
        VotingSystem voting = new VotingSystem();
        voting.vote("Alice");
        voting.vote("Bob");
        voting.vote("Alice");
        voting.vote("Charlie");
        voting.vote("Bob");
        voting.displayResults();
        
        System.out.println("\\n\\n=== SHOPPING CART ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 1);
        cart.addItem("Mouse", 2);
        cart.addItem("Keyboard", 1);
        cart.displayCart();
        
        
        System.out.println("\\n\\n=== BANKING SYSTEM ===");
        BankingSystem bank = new BankingSystem();
        bank.createAccount("ACC001", 50000.0);
        bank.createAccount("ACC002", 25000.0);
        bank.createAccount("ACC003", 75000.0);
        
        bank.requestWithdrawal("ACC001");
        bank.requestWithdrawal("ACC003");
        bank.requestWithdrawal("ACC002");
        
        bank.displayAccountsByBalance();
        bank.processWithdrawals();
    }
}