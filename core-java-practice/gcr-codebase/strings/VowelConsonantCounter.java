package strings;

public class VowelConsonantCounter {

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32;

        if (ch >= 'a' && ch <= 'z') {
            return "aeiou".indexOf(ch) >= 0 ? "Vowel" : "Consonant";
        }
        return "Not a Letter";
    }
}
