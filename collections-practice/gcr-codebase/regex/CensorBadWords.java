public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};
        
        String output = input;
        for (String badWord : badWords) {
            String regex = "\\b" + badWord + "\\b";
            output = output.replaceAll("(?i)" + regex, "****");
        }
        
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output: \"" + output + "\"");
    }
}