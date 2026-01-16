import java.util.*;

// Exception Classes
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class WalletNotFoundException extends Exception {
    public WalletNotFoundException(String message) {
        super(message);
    }
}

// Interface for transfer service
interface TransferService {
    void transfer(String fromWalletId, String toWalletId, double amount) throws InsufficientBalanceException, WalletNotFoundException;
    String getTransferType();
}

// Polymorphic transfer implementations
class WalletTransfer implements TransferService {
    private DigitalWalletSystem walletSystem;
    
    public WalletTransfer(DigitalWalletSystem walletSystem) {
        this.walletSystem = walletSystem;
    }
    
    @Override
    public void transfer(String fromWalletId, String toWalletId, double amount) 
            throws InsufficientBalanceException, WalletNotFoundException {
        
        Wallet fromWallet = walletSystem.getWallet(fromWalletId);
        Wallet toWallet = walletSystem.getWallet(toWalletId);
        
        if (fromWallet == null) {
            throw new WalletNotFoundException("Source wallet not found: " + fromWalletId);
        }
        
        if (toWallet == null) {
            throw new WalletNotFoundException("Destination wallet not found: " + toWalletId);
        }
        
        if (fromWallet.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance in wallet: " + fromWalletId);
        }
        
        fromWallet.debit(amount);
        toWallet.credit(amount);
        
        // Record transactions
        walletSystem.recordTransaction(fromWalletId, "DEBIT", amount, "Transfer to " + toWalletId);
        walletSystem.recordTransaction(toWalletId, "CREDIT", amount, "Transfer from " + fromWalletId);
        
        System.out.println("Wallet transfer completed: $" + amount + " from " + fromWalletId + " to " + toWalletId);
    }
    
    @Override
    public String getTransferType() {
        return "Wallet Transfer";
    }
}

class BankTransfer implements TransferService {
    private DigitalWalletSystem walletSystem;
    private double transferFee = 2.0; // $2 fee for bank transfers
    
    public BankTransfer(DigitalWalletSystem walletSystem) {
        this.walletSystem = walletSystem;
    }
    
    @Override
    public void transfer(String fromWalletId, String toBankAccount, double amount) 
            throws InsufficientBalanceException, WalletNotFoundException {
        
        Wallet fromWallet = walletSystem.getWallet(fromWalletId);
        
        if (fromWallet == null) {
            throw new WalletNotFoundException("Source wallet not found: " + fromWalletId);
        }
        
        double totalAmount = amount + transferFee;
        if (fromWallet.getBalance() < totalAmount) {
            throw new InsufficientBalanceException("Insufficient balance (including $" + transferFee + " fee)");
        }
        
        fromWallet.debit(totalAmount);
        
        // Record transactions
        walletSystem.recordTransaction(fromWalletId, "DEBIT", amount, "Bank transfer to " + toBankAccount);
        walletSystem.recordTransaction(fromWalletId, "FEE", transferFee, "Bank transfer fee");
        
        System.out.println("Bank transfer completed: $" + amount + " to " + toBankAccount + " (Fee: $" + transferFee + ")");
    }
    
    @Override
    public String getTransferType() {
        return "Bank Transfer";
    }
}

// Core Classes
class User {
    private String userId;
    private String name;
    private String email;
    private String phone;
    
    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}

class Wallet {
    private String walletId;
    private User owner;
    private double balance;
    private boolean isActive;
    private Date createdDate;
    
    public Wallet(String walletId, User owner) {
        this.walletId = walletId;
        this.owner = owner;
        this.balance = 0.0;
        this.isActive = true;
        this.createdDate = new Date();
    }
    
    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void debit(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        if (amount > 0) {
            balance -= amount;
        }
    }
    
    // Getters and Setters
    public String getWalletId() { return walletId; }
    public User getOwner() { return owner; }
    public double getBalance() { return balance; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
    public Date getCreatedDate() { return createdDate; }
}

class Transaction {
    private String transactionId;
    private String walletId;
    private String type; // CREDIT, DEBIT, FEE
    private double amount;
    private String description;
    private Date timestamp;
    
    public Transaction(String transactionId, String walletId, String type, double amount, String description) {
        this.transactionId = transactionId;
        this.walletId = walletId;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = new Date();
    }
    
    // Getters
    public String getTransactionId() { return transactionId; }
    public String getWalletId() { return walletId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public Date getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("%s | %s | $%.2f | %s | %s", 
                           transactionId, type, amount, description, timestamp);
    }
}

public class DigitalWalletSystem {
    private Map<String, User> users;
    private Map<String, Wallet> wallets;
    private List<Transaction> transactions;
    private TransferService transferService;
    private int transactionCounter = 1;
    
    public DigitalWalletSystem() {
        this.users = new HashMap<>();
        this.wallets = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.transferService = new WalletTransfer(this); // Default transfer service
    }
    
    // CRUD Operations
    public void registerUser(String userId, String name, String email, String phone) {
        User user = new User(userId, name, email, phone);
        users.put(userId, user);
        System.out.println("User registered: " + name);
    }
    
    public String createWallet(String userId) throws WalletNotFoundException {
        User user = users.get(userId);
        if (user == null) {
            throw new WalletNotFoundException("User not found: " + userId);
        }
        
        String walletId = "WALLET_" + userId;
        Wallet wallet = new Wallet(walletId, user);
        wallets.put(walletId, wallet);
        
        System.out.println("Wallet created for user: " + user.getName());
        return walletId;
    }
    
    public void addMoney(String walletId, double amount) throws WalletNotFoundException {
        Wallet wallet = wallets.get(walletId);
        if (wallet == null) {
            throw new WalletNotFoundException("Wallet not found: " + walletId);
        }
        
        wallet.credit(amount);
        recordTransaction(walletId, "CREDIT", amount, "Money added to wallet");
        
        System.out.println("Money added: $" + amount + " to wallet " + walletId);
    }
    
    public void withdrawMoney(String walletId, double amount) throws WalletNotFoundException, InsufficientBalanceException {
        Wallet wallet = wallets.get(walletId);
        if (wallet == null) {
            throw new WalletNotFoundException("Wallet not found: " + walletId);
        }
        
        wallet.debit(amount);
        recordTransaction(walletId, "DEBIT", amount, "Money withdrawn from wallet");
        
        System.out.println("Money withdrawn: $" + amount + " from wallet " + walletId);
    }
    
    public void transferFunds(String fromWalletId, String toWalletId, double amount) 
            throws InsufficientBalanceException, WalletNotFoundException {
        transferService.transfer(fromWalletId, toWalletId, amount);
    }
    
    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }
    
    public void recordTransaction(String walletId, String type, double amount, String description) {
        String transactionId = "TXN" + String.format("%06d", transactionCounter++);
        Transaction transaction = new Transaction(transactionId, walletId, type, amount, description);
        transactions.add(transaction);
    }
    
    public Wallet getWallet(String walletId) {
        return wallets.get(walletId);
    }
    
    public void displayWalletBalance(String walletId) throws WalletNotFoundException {
        Wallet wallet = wallets.get(walletId);
        if (wallet == null) {
            throw new WalletNotFoundException("Wallet not found: " + walletId);
        }
        
        System.out.println("\\n=== Wallet Balance ===");
        System.out.println("Wallet ID: " + walletId);
        System.out.println("Owner: " + wallet.getOwner().getName());
        System.out.println("Balance: $" + String.format("%.2f", wallet.getBalance()));
        System.out.println("Status: " + (wallet.isActive() ? "Active" : "Inactive"));
    }
    
    public void displayTransactionHistory(String walletId) {
        System.out.println("\\n=== Transaction History for " + walletId + " ===");
        
        List<Transaction> walletTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getWalletId().equals(walletId)) {
                walletTransactions.add(transaction);
            }
        }
        
        if (walletTransactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }
        
        // Sort by timestamp (most recent first)
        walletTransactions.sort((a, b) -> b.getTimestamp().compareTo(a.getTimestamp()));
        
        for (Transaction transaction : walletTransactions) {
            System.out.println(transaction);
        }
    }
    
    public static void main(String[] args) {
        DigitalWalletSystem walletSystem = new DigitalWalletSystem();
        
        try {
            // Register users
            walletSystem.registerUser("U001", "John Doe", "john@email.com", "1234567890");
            walletSystem.registerUser("U002", "Jane Smith", "jane@email.com", "0987654321");
            
            // Create wallets
            String wallet1 = walletSystem.createWallet("U001");
            String wallet2 = walletSystem.createWallet("U002");
            
            // Add money to wallets
            walletSystem.addMoney(wallet1, 1000.0);
            walletSystem.addMoney(wallet2, 500.0);
            
            // Display balances
            walletSystem.displayWalletBalance(wallet1);
            walletSystem.displayWalletBalance(wallet2);
            
            // Transfer money between wallets
            walletSystem.transferFunds(wallet1, wallet2, 200.0);
            
            // Switch to bank transfer service
            walletSystem.setTransferService(new BankTransfer(walletSystem));
            
            // Transfer to bank account
            walletSystem.transferFunds(wallet1, "BANK_ACC_123456", 100.0);
            
            // Withdraw money
            walletSystem.withdrawMoney(wallet2, 50.0);
            
            // Display final balances
            System.out.println("\\n=== Final Balances ===");
            walletSystem.displayWalletBalance(wallet1);
            walletSystem.displayWalletBalance(wallet2);
            
            // Display transaction history
            walletSystem.displayTransactionHistory(wallet1);
            walletSystem.displayTransactionHistory(wallet2);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}