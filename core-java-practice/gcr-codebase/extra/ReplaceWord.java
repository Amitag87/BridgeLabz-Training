package extra;

public class ReplaceWord {
    
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result.append(newWord);
            } else {
                result.append(words[i]);
            }
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String sentence = "Java is a programming language and Java is powerful";
        String oldWord = "Java";
        String newWord = "Python";
        
        String result = replaceWord(sentence, oldWord, newWord);
        
        System.out.println("Original: " + sentence);
        System.out.println("Replace '" + oldWord + "' with '" + newWord + "'");
        System.out.println("Result: " + result);
    }
}