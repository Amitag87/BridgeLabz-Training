public class OnlineBankingSystem {
    public static void main(String[] args) {
        Account account = new SavingsAccount("SAV001", 10000, 0.04);
        
        System.out.println("=== Concurrent Banking Operations ===\n");
        System.out.println("Initial Balance: $" + account.getBalance());
        
        // Create multiple threads for concurrent transactions
        Thread t1 = new Thread(new TransactionTask(account, "withdraw", 3000, "User1"));
        Thread t2 = new Thread(new TransactionTask(account, "deposit", 2000, "User2"));
        Thread t3 = new Thread(new TransactionTask(account, "withdraw", 4000, "User3"));
        Thread t4 = new Thread(new TransactionTask(account, "deposit", 1500, "User4"));
        
        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        // Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nFinal Balance: $" + account.getBalance());
    }
}

class TransactionTask implements Runnable {
    private Account account;
    private String operation;
    private double amount;
    private String user;
    
    public TransactionTask(Account account, String operation, double amount, String user) {
        this.account = account;
        this.operation = operation;
        this.amount = amount;
        this.user = user;
    }
    
    @Override
    public void run() {
        try {
            if ("withdraw".equals(operation)) {
                account.withdraw(amount);
                System.out.println(user + " withdrew $" + amount + " - Balance: $" + account.getBalance());
            } else if ("deposit".equals(operation)) {
                account.deposit(amount);
                System.out.println(user + " deposited $" + amount + " - Balance: $" + account.getBalance());
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(user + " failed: " + e.getMessage());
        }
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

abstract class Account {
    protected String accountNumber;
    protected double balance;
    
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public synchronized double getBalance() {
        return balance;
    }
    
    public synchronized void deposit(double amount) {
        balance += amount;
    }
    
    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    public abstract double calculateInterest();
}

class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available: $" + balance + ", Requested: $" + amount);
        }
        balance -= amount;
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (balance + overdraftLimit)) {
            throw new InsufficientBalanceException("Insufficient balance including overdraft. Available: $" + (balance + overdraftLimit) + ", Requested: $" + amount);
        }
        balance -= amount;
    }
    
    @Override
    public double calculateInterest() {
        return 0;
    }
}

class FixedDepositAccount extends Account {
    private double interestRate;
    private int termMonths;
    
    public FixedDepositAccount(String accountNumber, double balance, double interestRate, int termMonths) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.termMonths = termMonths;
    }
    
    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        throw new InsufficientBalanceException("Withdrawals not allowed from Fixed Deposit Account");
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate * (termMonths / 12.0);
    }
}

interface Transaction {
    void execute(double amount) throws InsufficientBalanceException;
}


