import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV001", "John Doe", 15000));
        accounts.add(new CurrentAccount("CUR001", "ABC Corp", 75000));
        
        System.out.println("=== Banking System ===");
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + " - " + account.getHolderName());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Interest: $" + account.calculateInterest());
            
            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println("Loan Eligible: " + loanable.calculateLoanEligibility());
                loanable.applyForLoan(50000);
            }
            System.out.println();
        }
    }
}