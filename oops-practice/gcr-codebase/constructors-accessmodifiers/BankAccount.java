public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }
    
    public void displayDetails() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    
    public void displaySavingsDetails() {
        System.out.println("Savings Account: " + accountNumber + ", Holder: " + accountHolder + ", Interest: " + interestRate + "%");
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", "John Doe", 1000.0);
        account.displayDetails();
        account.deposit(500.0);
        System.out.println("After deposit: $" + account.getBalance());
        
        SavingsAccount savings = new SavingsAccount("67890", "Alice Smith", 2000.0, 3.5);
        savings.displaySavingsDetails();
    }
}