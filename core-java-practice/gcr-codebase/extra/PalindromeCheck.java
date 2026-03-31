package extra;

public class PalindromeCheck {
    
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] testStrings = {"racecar", "A man a plan a canal Panama", "race a car", "hello"};
        
        for (String str : testStrings) {
            System.out.println("\"" + str + "\" is " + (isPalindrome(str) ? "" : "not ") + "a palindrome");
        }
    }
}