public class BankAccountManager {
    private String accountNumber;
    private double balance;
    
    public BankAccountManager(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    public double checkBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
        return balance;
    }
    
    public static void main(String[] args) {
        BankAccountManager account = new BankAccountManager("ACC123", 1000.0);
        
        System.out.println("=== Bank Account Manager ===");
        account.checkBalance();
        
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0); // Overdraft test
        account.deposit(-50.0);   // Invalid deposit test
        
        account.checkBalance();
    }
}