public class TextFormatter {
    
    public static String autoCorrectFormat(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }
        
        // Trim extra spaces and replace multiple spaces with single space
        String corrected = paragraph.trim().replaceAll("\\s+", " ");
        
        // Add single space after punctuation if missing
        corrected = corrected.replaceAll("([.!?])([A-Za-z])", "$1 $2");
        
        // Remove extra spaces before punctuation
        corrected = corrected.replaceAll("\\s+([.!?])", "$1");
        
        // Capitalize first letter of each sentence
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (int i = 0; i < corrected.length(); i++) {
            char c = corrected.charAt(i);
            
            if (capitalizeNext && Character.isLetter(c)) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(c);
            }
            
            if (c == '.' || c == '!' || c == '?') {
                capitalizeNext = true;
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String input1 = "hello world.how are you?i am fine!great to hear.";
        String input2 = "  this   is    poorly   formatted  .  what  do  you  think  ?  ";
        
        System.out.println("Original: " + input1);
        System.out.println("Corrected: " + autoCorrectFormat(input1));
        System.out.println();
        
        System.out.println("Original: " + input2);
        System.out.println("Corrected: " + autoCorrectFormat(input2));
    }
}