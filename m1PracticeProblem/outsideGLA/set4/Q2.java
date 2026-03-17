import java.util.*;

abstract class Account {
    String accountNumber, holderName;
    double balance;

    Account(String accNo, String name, double bal) {
        accountNumber = accNo;
        holderName = name;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Successfully");
    }

    abstract void withdraw(double amount);
}

// SAVINGS
class SavingsAccount extends Account {

    SavingsAccount(String a, String b, double c) {
        super(a, b, c);
    }

    void withdraw(double amount) {
        double total = amount + 2;

        if (balance - total < 0) {
            System.out.println("Insufficient Funds");
            return;
        }

        balance -= total;
        System.out.println("Withdrawal Successful");
    }
}

// CURRENT
class CurrentAccount extends Account {

    CurrentAccount(String a, String b, double c) {
        super(a, b, c);
    }

    void withdraw(double amount) {
        double total = amount + 5;

        if (balance - total < -10000) {
            System.out.println("Insufficient Funds");
            return;
        }

        balance -= total;
        System.out.println("Withdrawal Successful");
    }
}

// BUSINESS
class BusinessAccount extends Account {

    BusinessAccount(String a, String b, double c) {
        super(a, b, c);
    }

    void withdraw(double amount) {
        double charge = amount * 0.01;
        double total = amount + charge;

        if (balance - total < -50000) {
            System.out.println("Insufficient Funds");
            return;
        }

        balance -= total;
        System.out.println("Withdrawal Successful");
    }
}

// MANAGER
class BankManager {
    List<Account> accounts = new ArrayList<>();

    Account find(String accNo) {
        for (Account a : accounts) {
            if (a.accountNumber.equals(accNo)) return a;
        }
        return null;
    }

    void create(String accNo, String name, String type, double bal) {
        if (find(accNo) != null) return;

        Account acc = null;

        switch (type) {
            case "SavingsAccount":
                acc = new SavingsAccount(accNo, name, bal);
                break;
            case "CurrentAccount":
                acc = new CurrentAccount(accNo, name, bal);
                break;
            case "BusinessAccount":
                acc = new BusinessAccount(accNo, name, bal);
                break;
        }

        accounts.add(acc);
        System.out.println("Account Created: " + accNo);
    }

    void deposit(String accNo, double amt) {
        Account acc = find(accNo);
        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }
        acc.deposit(amt);
    }

    void withdraw(String accNo, double amt) {
        Account acc = find(accNo);
        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }
        acc.withdraw(amt);
    }
}

public class Q2{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        BankManager bm = new BankManager();

        while (n-- > 0) {
            String line = sc.nextLine();
            String[] p = line.split(" ");

            switch (p[0]) {

                case "Create":
                    bm.create(p[1], p[2], p[3],
                              Double.parseDouble(p[4]));
                    break;

                case "Deposit":
                    bm.deposit(p[1], Double.parseDouble(p[2]));
                    break;

                case "Withdraw":
                    bm.withdraw(p[1], Double.parseDouble(p[2]));
                    break;
            }
        }
    }
}