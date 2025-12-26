package extra;

public class RemoveSpecificCharacter {
    
    public static String removeCharacter(String str, char charToRemove) {
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c != charToRemove) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        
        String result = removeCharacter(input, charToRemove);
        
        System.out.println("String: " + input);
        System.out.println("Character to Remove: '" + charToRemove + "'");
        System.out.println("Modified String: " + result);
    }
}