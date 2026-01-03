// Demo class for hierarchical inheritance
public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("=== Bank Account Types (Hierarchical Inheritance) ===");
        
        // All three subclasses inherit from BankAccount
        SavingsAccount savings = new SavingsAccount("SAV001", 5000, 3.5);
        CheckingAccount checking = new CheckingAccount("CHK001", 2000, 500);
        FixedDepositAccount fd = new FixedDepositAccount("FD001", 10000, 12, 11000);
        
        System.out.println("Savings Account:");
        savings.displayAccountInfo();
        savings.displayAccountType();
        System.out.println("Interest Earned: $" + savings.calculateInterest());
        System.out.println();
        
        System.out.println("Checking Account:");
        checking.displayAccountInfo();
        checking.displayAccountType();
        System.out.println("Can withdraw $600? " + checking.canWithdraw(600));
        System.out.println();
        
        System.out.println("Fixed Deposit Account:");
        fd.displayAccountInfo();
        fd.displayAccountType();
    }
}