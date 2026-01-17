public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 100000;
        
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        long stringBufferTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append("hello");
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        
        System.out.println("StringBuffer time: " + stringBufferTime + " ns");
        System.out.println("StringBuilder time: " + stringBuilderTime + " ns");
        System.out.println("StringBuilder is " + (stringBufferTime / (double) stringBuilderTime) + "x faster");
    }
}