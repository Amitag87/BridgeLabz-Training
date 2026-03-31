import java.util.Arrays;

// LeetCode 242: Valid Anagram
public class ValidAnagram {
    public static void main(String[] args) {
        String[][] testCases = {
            {"anagram", "nagaram"},
            {"rat", "car"},
            {"listen", "silent"}
        };
        
        for (String[] test : testCases) {
            boolean result = isAnagram(test[0], test[1]);
            System.out.println("\"" + test[0] + "\" and \"" + test[1] + "\" -> " + result);
        }
    }
    
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        return Arrays.equals(sArray, tArray);
    }
}