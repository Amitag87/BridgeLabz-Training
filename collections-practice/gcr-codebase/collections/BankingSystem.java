import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        Map<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 12000);
        accounts.put(103, 8000);

        Queue<Integer> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add(101);
        withdrawalQueue.add(103);

        while (!withdrawalQueue.isEmpty()) {
            int acc = withdrawalQueue.remove();
            accounts.put(acc, accounts.get(acc) - 1000);
        }

        TreeMap<Integer, Integer> sortedAccounts = new TreeMap<>();

        for (int acc : accounts.keySet()) {
            sortedAccounts.put(accounts.get(acc), acc);
        }

        System.out.println("Accounts Sorted by Balance:");
        System.out.println(sortedAccounts);
    }
}
