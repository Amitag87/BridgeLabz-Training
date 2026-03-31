import java.util.*;

public class ListInterfaceProblems {
    
    // 1. Reverse a List without built-in methods
    public static <T> void reverseList(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            T temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }
    
    // 2. Find Frequency of Elements
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String item : list) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }
        return frequency;
    }
    
    // 3. Rotate Elements in a List
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        if (positions == 0) return;
        
        List<T> temp = new ArrayList<>(list.subList(0, positions));
        for (int i = 0; i < size - positions; i++) {
            list.set(i, list.get(i + positions));
        }
        for (int i = 0; i < positions; i++) {
            list.set(size - positions + i, temp.get(i));
        }
    }
    
    // 4. Remove Duplicates While Preserving Order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        for (T item : list) {
            seen.add(item);
        }
        return new ArrayList<>(seen);
    }
    
    // 5. Find Nth Element from End (LinkedList)
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || list.isEmpty()) return null;
        
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        
        // Move first pointer n steps ahead
        for (int i = 0; i < n && first.hasNext(); i++) {
            first.next();
        }
        
        // Move both pointers until first reaches end
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        
        return second.hasNext() ? second.next() : null;
    }
    
    public static void main(String[] args) {
        // Test 1: Reverse List
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
        
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
        
        // Test 2: Frequency
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("\\nFrequency: " + findFrequency(fruits));
        
        // Test 3: Rotate
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("\\nOriginal: " + numbers);
        rotateList(numbers, 2);
        System.out.println("Rotated by 2: " + numbers);
        
        // Test 4: Remove Duplicates
        List<Integer> withDuplicates = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("\\nWith duplicates: " + withDuplicates);
        System.out.println("Without duplicates: " + removeDuplicates(withDuplicates));
        
        // Test 5: Nth from End
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("\\nList: " + letters);
        System.out.println("2nd from end: " + findNthFromEnd(letters, 2));
    }
}