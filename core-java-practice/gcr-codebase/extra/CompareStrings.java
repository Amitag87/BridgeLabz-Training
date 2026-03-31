package extra;

public class CompareStrings {
    
    public static int compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            }
        }
        
        return Integer.compare(str1.length(), str2.length());
    }
    
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        
        int result = compareStrings(str1, str2);
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        
        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
}