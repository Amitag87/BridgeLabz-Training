package extra;

import java.util.*;

public class MostFrequentCharacter {
    
    public static char findMostFrequentChar(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        char mostFrequent = str.charAt(0);
        int maxCount = 0;
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        
        return mostFrequent;
    }
    
    public static void main(String[] args) {
        String input = "success";
        char mostFrequent = findMostFrequentChar(input);
        
        System.out.println("String: " + input);
        System.out.println("Most Frequent Character: " + mostFrequent);
    }
}