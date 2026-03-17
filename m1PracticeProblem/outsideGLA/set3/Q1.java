import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q1 {

    static Set<String> seen = new HashSet<>();

    public static String validateURL(String url) {

        // Rule 1: Format check
        if (!url.matches("^(http://|https://).+\\..+")) {
            return "INVALID URL: format is invalid";
        }

        // Rule 2: Protocol check
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return "INVALID URL: protocol is invalid";
        }

        // Extract parts
        Pattern p = Pattern.compile("^(http://|https://)([^.]+)(\\..+)$");
        Matcher m = p.matcher(url);

        if (!m.matches()) {
            return "INVALID URL: format is invalid";
        }

        String website = m.group(2);
        String domain = m.group(3);

        // Rule 3: Website name
        if (!website.matches("[a-z]{1,10}")) {
            return "INVALID URL: website name is invalid";
        }

        // Rule 4: Domain
        if (!domain.matches("\\.(com|co|in|org|gov)")) {
            return "INVALID URL: domain is invalid";
        }

        // Rule 5: Duplicate
        if (seen.contains(url)) {
            return "DUPLICATE URL FOUND";
        }

        seen.add(url);
        return "VALID URL";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(validateURL(sc.nextLine().trim()));
        }
    }
}