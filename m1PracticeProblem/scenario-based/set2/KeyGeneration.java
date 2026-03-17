import java.util.*;

public class KeyGeneration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String str = sc.nextLine();

            String result = validate(str);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("The generated key is - " + generateKey(str));
            }
        }
    }

    // 🔍 Validation
    static String validate(String s) {
        if (s.length() == 0) return "Invalid Input (empty string)";
        if (s.length() < 6) return "Invalid Input (length < 6)";

        for (char c : s.toCharArray()) {
            if (c == ' ') return "Invalid Input (contains space)";
            if (Character.isDigit(c)) return "Invalid Input (contains digits)";
            if (!Character.isLetter(c)) return "Invalid Input (contains special character)";
        }
        return null; // valid
    }

    // 🔑 Key Generation
    static String generateKey(String s) {
        // 1. lowercase
        s = s.toLowerCase();

        // 2. remove even ASCII chars
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c % 2 != 0) {
                temp.append(c);
            }
        }

        // 3. reverse
        temp.reverse();

        // 4. uppercase even index
        for (int i = 0; i < temp.length(); i += 2) {
            temp.setCharAt(i, Character.toUpperCase(temp.charAt(i)));
        }

        return temp.toString();
    }
}