public class PalindromeChecker {
    String text;
    
    public PalindromeChecker(String text) {
        this.text = text;
    }
    
    public boolean isPalindrome() {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
    
    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        
        checker1.displayResult();
        checker2.displayResult();
    }
}