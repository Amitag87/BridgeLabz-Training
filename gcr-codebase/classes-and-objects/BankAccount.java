public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;
    
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("State of Chennai", "12345", 700.0);
        
        account.displayBalance();
        account.deposit(200.0);
        account.displayBalance();
        account.withdraw(100.0);
        account.displayBalance();
        account.withdraw(1000.0);
    }
}