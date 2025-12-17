public class Main {
    public static void main(String[] args) {

        String str = "babad";
        int begin = 0, maxLen = 1;

        for (int center = 0; center < str.length(); center++) {

            
            int l = center, r = center;
            while (l >= 0 && r < str.length() &&
                   str.charAt(l) == str.charAt(r)) {

                if (r - l + 1 > maxLen) {
                    begin = l;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }

            
            l = center;
            r = center + 1;
            while (l >= 0 && r < str.length() &&
                   str.charAt(l) == str.charAt(r)) {

                if (r - l + 1 > maxLen) {
                    begin = l;
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        System.out.println(str.substring(begin, begin + maxLen));
    }
}
