import java.util.ArrayList;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw type usage
        list.add("Hello");
        list.add(123);
        list.add(true);
        
        System.out.println("List contents: " + list);
        
        // Without @SuppressWarnings, this would show unchecked warnings
        for (Object item : list) {
            System.out.println("Item: " + item);
        }
    }
}