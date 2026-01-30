public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String input = "This    is   an    example    with     multiple    spaces.";
        String regex = "\\s+";
        
        String output = input.replaceAll(regex, " ");
        
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output: \"" + output + "\"");
    }
}