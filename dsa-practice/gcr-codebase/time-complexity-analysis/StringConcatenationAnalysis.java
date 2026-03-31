public class StringConcatenationAnalysis {
    public static void main(String[] args) {
        int[] iterations = {1000, 10000, 50000};
        
        for (int count : iterations) {
            System.out.println("\nConcatenation Count: " + count);
            
            // String concatenation (O(N²))
            long start = System.nanoTime();
            String result1 = testStringConcatenation(count);
            long stringTime = System.nanoTime() - start;
            
            // StringBuilder (O(N))
            start = System.nanoTime();
            String result2 = testStringBuilder(count);
            long sbTime = System.nanoTime() - start;
            
            // StringBuffer (O(N))
            start = System.nanoTime();
            String result3 = testStringBuffer(count);
            long sbfTime = System.nanoTime() - start;
            
            System.out.println("String:        " + stringTime / 1000000 + " ms");
            System.out.println("StringBuilder: " + sbTime / 1000000 + " ms");
            System.out.println("StringBuffer:  " + sbfTime / 1000000 + " ms");
            System.out.println("String vs StringBuilder: " + (stringTime / (double) sbTime) + "x slower");
        }
    }
    
    static String testStringConcatenation(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "Hello";
        }
        return result;
    }
    
    static String testStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("Hello");
        }
        return sb.toString();
    }
    
    static String testStringBuffer(int count) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append("Hello");
        }
        return sbf.toString();
    }
}