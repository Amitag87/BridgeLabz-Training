public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("\"" + test1 + "\" -> " + solution.isPalindrome(test1));
        
        String test2 = "race a car";
        System.out.println("\"" + test2 + "\" -> " + solution.isPalindrome(test2));
        
        String test3 = " ";
        System.out.println("\"" + test3 + "\" -> " + solution.isPalindrome(test3));
    }
}