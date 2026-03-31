import java.util.*;
import java.util.regex.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            System.out.println(processTemplate(line));
        }
    }

    public static String processTemplate(String line) {
        Pattern pattern = Pattern.compile("\\$\\{(\\w+):(.*?)\\}");
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String type = matcher.group(1);
            String value = matcher.group(2);

            String replacement = processPlaceholder(type, value);

            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static String processPlaceholder(String type, String value) {
        try {
            switch (type) {
                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "REPEAT":
                    String[] parts = value.split(",");
                    if (parts.length != 2) return "INVALID";

                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        sb.append(word);
                    }
                    return sb.toString();

                case "DATE":
                    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate date = LocalDate.parse(value, inputFormat);
                    return date.format(outputFormat);

                default:
                    return "INVALID";
            }
        } catch (Exception e) {
            return "INVALID";
        }
    }
}