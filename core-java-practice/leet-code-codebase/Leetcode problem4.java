import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static int main(String s) {
	String s = "abcabcbb";
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }

    
        
        
    
}