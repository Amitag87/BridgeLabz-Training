import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    
    // UC1: Roll dice to get number 1-6
    public static int rollDice() {
        return random.nextInt(6) + 1;
    }
    
    // UC2: Check options - No Play(0), Ladder(1), Snake(2)
    public static int checkOption() {
        return random.nextInt(3);
    }
    
    // UC3 & UC4 & UC5: Single player game with reporting
    public static void singlePlayerGame() {
        int position = 0;
        int diceCount = 0;
        
        System.out.println("Single Player Game Started");
        
        while(position != 100) {
            int dice = rollDice();
            int option = checkOption();
            int prevPosition = position;
            diceCount++;
            
            System.out.println("Roll " + diceCount + ": Position " + position + ", Dice: " + dice);
            
            switch(option) {
                case 0: // No Play
                    System.out.println("No Play - Stay at " + position);
                    break;
                case 1: // Ladder
                    position += dice;
                    if(position > 100) {
                        position = prevPosition; // UC4: Stay if exceeds 100
                        System.out.println("Ladder - Exceeds 100, stay at " + position);
                    } else {
                        System.out.println("Ladder - Move to " + position);
                    }
                    break;
                case 2: // Snake
                    position -= dice;
                    if(position < 0) {
                        position = 0; // UC3: Restart from 0
                        System.out.println("Snake - Below 0, restart at 0");
                    } else {
                        System.out.println("Snake - Move to " + position);
                    }
                    break;
            }
        }
        System.out.println("Won in " + diceCount + " rolls!\n");
    }
    
    // UC6 & UC7: Two player game with ladder bonus
    public static void twoPlayerGame() {
        int p1 = 0, p2 = 0;
        int currentPlayer = 1;
        int diceCount = 0;
        
        System.out.println("Two Player Game Started");
        
        while(p1 != 100 && p2 != 100) {
            int dice = rollDice();
            int option = checkOption();
            diceCount++;
            
            System.out.println("Player " + currentPlayer + " - Roll " + diceCount);
            
            if(currentPlayer == 1) {
                int prev = p1;
                System.out.println("Position: " + p1 + ", Dice: " + dice);
                
                switch(option) {
                    case 0:
                        System.out.println("No Play");
                        currentPlayer = 2;
                        break;
                    case 1:
                        p1 += dice;
                        if(p1 > 100) {
                            p1 = prev;
                            System.out.println("Ladder - Stay at " + p1);
                        } else {
                            System.out.println("Ladder - Move to " + p1 + " (Play again!)");
                        }
                        break;
                    case 2:
                        p1 -= dice;
                        if(p1 < 0) p1 = 0;
                        System.out.println("Snake - Move to " + p1);
                        currentPlayer = 2;
                        break;
                }
            } else {
                int prev = p2;
                System.out.println("Position: " + p2 + ", Dice: " + dice);
                
                switch(option) {
                    case 0:
                        System.out.println("No Play");
                        currentPlayer = 1;
                        break;
                    case 1:
                        p2 += dice;
                        if(p2 > 100) {
                            p2 = prev;
                            System.out.println("Ladder - Stay at " + p2);
                        } else {
                            System.out.println("Ladder - Move to " + p2 + " (Play again!)");
                        }
                        break;
                    case 2:
                        p2 -= dice;
                        if(p2 < 0) p2 = 0;
                        System.out.println("Snake - Move to " + p2);
                        currentPlayer = 1;
                        break;
                }
            }
        }
        
        System.out.println("Player " + (p1 == 100 ? "1" : "2") + " won!");
        System.out.println("Total rolls: " + diceCount + "\n");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Snake and Ladder Game ===");
        System.out.println("1. Single Player\n2. Two Player");
        System.out.print("Choose: ");
        
        int choice = scanner.nextInt();
        
        if(choice == 1) {
            singlePlayerGame();
        } else if(choice == 2) {
            twoPlayerGame();
        } else {
            System.out.println("Invalid choice!");
        }
    }
}