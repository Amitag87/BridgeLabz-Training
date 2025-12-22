package strings;

import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        int n = deck.length;

        deck = shuffleDeck(deck, n);

        System.out.print("Enter number of players: ");
        int x = input.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = input.nextInt();

        String[][] players = distributeCards(deck, x, cardsPerPlayer);
        
        if (players != null) {
            printPlayers(players);
        } else {
            System.out.println("Error: Not enough cards in the deck for that many players.");
        }
    }

    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck, int n) {
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            // Step 3: Swap current card with the random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int x, int cardsPerPlayer) {
        if (x * cardsPerPlayer > deck.length) {
            return null;
        }

        String[][] players = new String[x][cardsPerPlayer];
        int deckIndex = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[deckIndex];
                deckIndex++;
            }
        }
        return players;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s Hand:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(" - " + players[i][j]);
            }
        }
    }
}