import java.util.*;
import java.util.regex.*;

public class Q1 {

    public static String evaluate(String input) {

        // Step 1: Replace valid tags
        Pattern valid = Pattern.compile(
            "\\[(SUM|MUL|MAX|MIN):(-?(0|[1-9]\\d*))(,-?(0|[1-9]\\d*))+\\]"
        );

        Matcher m = valid.matcher(input);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            String op = m.group(1);
            String expr = m.group(2) + input.substring(m.start() + op.length() + 3, m.end() - 1);

            String[] nums = expr.split(",");
            int result = 0;

            switch (op) {
                case "SUM":
                    for (String n : nums) result += Integer.parseInt(n);
                    break;

                case "MUL":
                    result = 1;
                    for (String n : nums) result *= Integer.parseInt(n);
                    break;

                case "MAX":
                    result = Integer.MIN_VALUE;
                    for (String n : nums)
                        result = Math.max(result, Integer.parseInt(n));
                    break;

                case "MIN":
                    result = Integer.MAX_VALUE;
                    for (String n : nums)
                        result = Math.min(result, Integer.parseInt(n));
                    break;
            }

            m.appendReplacement(sb, String.valueOf(result));
        }
        m.appendTail(sb);

        // Step 2: Replace any remaining [ ... ] with ERROR
        return sb.toString().replaceAll("\\[[^\\]]*\\]?", "ERROR");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(evaluate(sc.nextLine()));
        }
    }
}