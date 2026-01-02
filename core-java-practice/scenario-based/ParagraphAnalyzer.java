public class ParagraphAnalyzer {
    
    public static int countWords(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return 0;
        }
        return paragraph.trim().split("\\s+").length;
    }
    
    public static String findLongestWord(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }
        
        String[] words = paragraph.trim().split("\\s+");
        String longest = "";
        
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }
        return longest;
    }
    
    public static String replaceWord(String paragraph, String oldWord, String newWord) {
        if (paragraph == null || oldWord == null || newWord == null) {
            return paragraph;
        }
        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }
    
    public static void analyzeParagraph(String paragraph) {
        System.out.println("Paragraph: " + paragraph);
        System.out.println("Word count: " + countWords(paragraph));
        System.out.println("Longest word: " + findLongestWord(paragraph));
        
        String replaced = replaceWord(paragraph, "java", "Python");
        System.out.println("After replacing 'java' with 'Python': " + replaced);
        System.out.println();
    }
    
    public static void main(String[] args) {
        String paragraph1 = "Java is a powerful programming language. Java developers are in high demand.";
        String paragraph2 = "   ";
        String paragraph3 = "";
        String paragraph4 = "The quick brown fox jumps over the lazy dog enthusiastically.";
        
        analyzeParagraph(paragraph1);
        analyzeParagraph(paragraph2);
        analyzeParagraph(paragraph3);
        analyzeParagraph(paragraph4);
    }
}