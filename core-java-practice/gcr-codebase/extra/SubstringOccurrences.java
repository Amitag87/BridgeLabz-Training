package extra;

public class SubstringOccurrences {
    
    public static int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String str = "hello world hello universe hello";
        String substring = "hello";
        
        int occurrences = countOccurrences(str, substring);
        
        System.out.println("String: " + str);
        System.out.println("Substring: " + substring);
        System.out.println("Occurrences: " + occurrences);
    }
}