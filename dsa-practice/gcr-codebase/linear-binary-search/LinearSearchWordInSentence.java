public class LinearSearchWordInSentence {
    public static void main(String[] args) {
        String[] sentences = {
            "Java is a programming language",
            "Python is easy to learn",
            "JavaScript runs in browsers",
            "C++ is powerful for system programming"
        };
        String targetWord = "programming";
        
        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }
    
    static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}