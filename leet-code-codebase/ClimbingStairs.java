public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1; // f(1)
        int prev1 = 2; // f(2)
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        
        System.out.println("climbStairs(2) = " + solution.climbStairs(2)); // Expected: 2
        System.out.println("climbStairs(3) = " + solution.climbStairs(3)); // Expected: 3
        System.out.println("climbStairs(4) = " + solution.climbStairs(4)); // Expected: 5
        System.out.println("climbStairs(5) = " + solution.climbStairs(5)); // Expected: 8
    }
}