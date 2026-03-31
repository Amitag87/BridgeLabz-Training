// FixedDepositAccount extends BankAccount
public class FixedDepositAccount extends BankAccount {
    private int termInMonths;
    private double maturityAmount;
    
    public FixedDepositAccount(String accountNumber, double balance, int termInMonths, double maturityAmount) {
        super(accountNumber, balance);
        this.termInMonths = termInMonths;
        this.maturityAmount = maturityAmount;
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Term: " + termInMonths + " months");
        System.out.println("Maturity Amount: $" + maturityAmount);
    }
}