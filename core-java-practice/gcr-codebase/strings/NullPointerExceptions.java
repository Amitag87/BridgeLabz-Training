package strings;
public class NullPointerExceptions {

    public static void generateException() {
        String text = null;   
        System.out.println(text.length());
    }

  
    public static void handleException() {
        String text = null;  
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: String is null");
        }
    }

    public static void main(String[] args) {

    
        System.out.println("Generating Exception:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main method");
        }

        System.out.println("\nHandling Exception:");
        handleException();
    }

}