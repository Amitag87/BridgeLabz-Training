import java.util.*;

class Transaction {
    String type;
    int amount;
    int remainingLimit;

    Transaction(String type, int amount, int remainingLimit) {
        this.type = type;
        this.amount = amount;
        this.remainingLimit = remainingLimit;
    }
}

class CreditCard {
    String cardNumber;
    String holderName;
    int creditLimit;
    int availableLimit;
    List<Transaction> transactions = new ArrayList<>();

    CreditCard(String cardNumber, String holderName, int creditLimit) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.creditLimit = creditLimit;
        this.availableLimit = creditLimit;
    }
}

public class Q2 {

    static Map<String, CreditCard> map = new HashMap<>();

    // ISSUE
    public static void issue(String cardNumber, String name, int limit) {
        if (!map.containsKey(cardNumber)) {
            map.put(cardNumber, new CreditCard(cardNumber, name, limit));
        }
    }

    // SPEND
    public static void spend(String cardNumber, int amount) {
        CreditCard card = map.get(cardNumber);

        if (card == null || amount > card.availableLimit) {
            System.out.println("Transaction declined");
            return;
        }

        card.availableLimit -= amount;
        card.transactions.add(new Transaction("SPEND", amount, card.availableLimit));

        System.out.println("SPENT " + cardNumber + " " + card.availableLimit);
    }

    // PAYMENT
    public static void payment(String cardNumber, int amount) {
        CreditCard card = map.get(cardNumber);

        if (card == null) {
            System.out.println("Card not found");
            return;
        }

        card.availableLimit += amount;
        if (card.availableLimit > card.creditLimit) {
            card.availableLimit = card.creditLimit;
        }

        card.transactions.add(new Transaction("PAYMENT", amount, card.availableLimit));

        System.out.println("PAYMENT DONE " + cardNumber + " " + card.availableLimit);
    }

    // HOLDER
    public static void holder(String name) {
        List<CreditCard> list = new ArrayList<>();

        for (CreditCard c : map.values()) {
            if (c.holderName.equals(name)) {
                list.add(c);
            }
        }

        if (list.isEmpty()) {
            System.out.println("No cards found");
            return;
        }

        list.sort(Comparator.comparing(c -> c.cardNumber));

        for (CreditCard c : list) {
            System.out.println(c.cardNumber + " " + c.availableLimit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");

            String cmd = parts[0];

            switch (cmd) {
                case "ISSUE":
                    issue(parts[1], parts[2], Integer.parseInt(parts[3]));
                    break;

                case "SPEND":
                    spend(parts[1], Integer.parseInt(parts[2]));
                    break;

                case "PAYMENT":
                    payment(parts[1], Integer.parseInt(parts[2]));
                    break;

                case "HOLDER":
                    holder(parts[1]);
                    break;
            }
        }
    }
}