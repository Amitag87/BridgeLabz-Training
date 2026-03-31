public class FibonacciPerformanceAnalysis {
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 35};
        
        for (int n : values) {
            System.out.println("\nFibonacci(" + n + "):");
            
            // Iterative approach
            long start = System.nanoTime();
            long iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - start;
            
            // Recursive approach (skip for large values)
            long recursiveTime = 0;
            long recursiveResult = 0;
            if (n <= 35) {
                start = System.nanoTime();
                recursiveResult = fibonacciRecursive(n);
                recursiveTime = System.nanoTime() - start;
            }
            
            System.out.println("Iterative: " + iterativeResult + " (" + iterativeTime / 1000 + " μs)");
            if (n <= 35) {
                System.out.println("Recursive: " + recursiveResult + " (" + recursiveTime / 1000000 + " ms)");
                System.out.println("Performance Ratio: " + (recursiveTime / (double) iterativeTime) + "x slower");
            } else {
                System.out.println("Recursive: Skipped (too slow for n > 35)");
            }
        }
    }
    
    static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}