public class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4%
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for savings account");
        } else {
            System.out.println("Loan application rejected");
        }
    }
    
    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 10000; // Minimum balance requirement
    }
}