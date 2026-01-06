public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1, right = x;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    public static void main(String[] args) {
        Sqrt solution = new Sqrt();
        
        System.out.println("sqrt(4) = " + solution.mySqrt(4)); // Expected: 2
        System.out.println("sqrt(8) = " + solution.mySqrt(8)); // Expected: 2
        System.out.println("sqrt(1) = " + solution.mySqrt(1)); // Expected: 1
        System.out.println("sqrt(16) = " + solution.mySqrt(16)); // Expected: 4
    }
}