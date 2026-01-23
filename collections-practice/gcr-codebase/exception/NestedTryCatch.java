import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 20, 30, 40, 50};
        
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            int element = array[index];
            
            try {
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();
                int result = element / divisor;
                System.out.println("Result: " + result);
                
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
        
        scanner.close();
    }
}