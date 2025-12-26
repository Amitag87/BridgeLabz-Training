package extra;

import java.util.Arrays;

public class AnagramCheck {
    
    public static boolean areAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase().replaceAll("\\s", "");
        str2 = str2.toLowerCase().replaceAll("\\s", "");
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        
        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams of each other");
        } else {
            System.out.println("The strings are not anagrams");
        }
        
        // Test with another pair
        String str3 = "hello";
        String str4 = "world";
        System.out.println("\nString 3: " + str3);
        System.out.println("String 4: " + str4);
        System.out.println("Are anagrams: " + areAnagrams(str3, str4));
    }
}