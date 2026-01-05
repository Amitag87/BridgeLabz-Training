import java.util.Scanner;

class CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            next.append(count).append(s.charAt(s.length() - 1));
            s = next.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountAndSay sol = new CountAndSay();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Count and Say term: " + sol.countAndSay(n));
    }
}
