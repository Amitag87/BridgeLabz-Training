// CheckingAccount extends BankAccount
public class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Daily Withdrawal Limit: $" + withdrawalLimit);
    }
    
    public boolean canWithdraw(double amount) {
        return amount <= withdrawalLimit && amount <= balance;
    }
}