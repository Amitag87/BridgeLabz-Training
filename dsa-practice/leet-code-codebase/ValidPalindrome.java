// LeetCode 125: Valid Palindrome
public class ValidPalindrome {
    public static void main(String[] args) {
        String[] testCases = {
            "A man, a plan, a canal: Panama",
            "race a car",
            " "
        };
        
        for (String s : testCases) {
            boolean result = isPalindrome(s);
            System.out.println("\"" + s + "\" -> " + result);
        }
    }
    
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
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
}