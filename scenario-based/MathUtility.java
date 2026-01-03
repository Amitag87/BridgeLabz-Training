public class MathUtility {
    
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial not defined for negative numbers");
            return -1;
        }
        if (n == 0 || n == 1) return 1;
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static long fibonacci(int n) {
        if (n < 0) {
            System.out.println("Fibonacci not defined for negative numbers");
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Math Utility Functions ===");
        
        // Test factorial
        System.out.println("Factorial Tests:");
        System.out.println("5! = " + factorial(5));
        System.out.println("0! = " + factorial(0));
        System.out.println("(-3)! = " + factorial(-3));
        
        // Test prime
        System.out.println("\nPrime Tests:");
        int[] primeTests = {2, 17, 25, 1, 0, -5};
        for (int num : primeTests) {
            System.out.println(num + " is prime: " + isPrime(num));
        }
        
        // Test GCD
        System.out.println("\nGCD Tests:");
        System.out.println("GCD(48, 18) = " + gcd(48, 18));
        System.out.println("GCD(7, 13) = " + gcd(7, 13));
        System.out.println("GCD(-12, 8) = " + gcd(-12, 8));
        
        // Test Fibonacci
        System.out.println("\nFibonacci Tests:");
        for (int i = 0; i <= 10; i++) {
            System.out.println("F(" + i + ") = " + fibonacci(i));
        }
        System.out.println("F(-1) = " + fibonacci(-1));
    }
}