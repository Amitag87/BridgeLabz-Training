public class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2%
    
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Business loan of $" + amount + " approved for current account");
        } else {
            System.out.println("Loan application rejected");
        }
    }
    
    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 50000; // Higher requirement for business loans
    }
}