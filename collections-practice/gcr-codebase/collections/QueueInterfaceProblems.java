import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;
    
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity first
    }
    
    @Override
    public String toString() {
        return name + "(" + severity + ")";
    }
}

class StackUsingQueues<T> {
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();
    
    public void push(T item) {
        q2.offer(item);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public T pop() {
        return q1.isEmpty() ? null : q1.poll();
    }
    
    public T top() {
        return q1.isEmpty() ? null : q1.peek();
    }
}

class CircularBuffer<T> {
    private T[] buffer;
    private int head = 0;
    private int size = 0;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
    }
    
    public void insert(T item) {
        buffer[head] = item;
        head = (head + 1) % capacity;
        if (size < capacity) size++;
    }
    
    public List<T> getBuffer() {
        List<T> result = new ArrayList<>();
        int start = size < capacity ? 0 : head;
        for (int i = 0; i < size; i++) {
            result.add(buffer[(start + i) % capacity]);
        }
        return result;
    }
}

public class QueueInterfaceProblems {
    
    // 1. Reverse a Queue
    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }
    
    // 2. Generate Binary Numbers
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        
        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            result.add(current);
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        return result;
    }
    
    // 3. Hospital Triage System
    public static void hospitalTriage(List<Patient> patients) {
        PriorityQueue<Patient> triage = new PriorityQueue<>(patients);
        System.out.println("Treatment order:");
        while (!triage.isEmpty()) {
            System.out.println(triage.poll());
        }
    }
    
    public static void main(String[] args) {
        // Test 1: Reverse Queue
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
        
        // Test 2: Binary Numbers
        System.out.println("\\nFirst 5 binary numbers: " + generateBinaryNumbers(5));
        
        // Test 3: Hospital Triage
        List<Patient> patients = Arrays.asList(
            new Patient("John", 3),
            new Patient("Alice", 5),
            new Patient("Bob", 2)
        );
        System.out.println("\\nPatients: " + patients);
        hospitalTriage(patients);
        
        // Test 4: Stack Using Queues
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("\\nStack top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack top after pop: " + stack.top());
        
        // Test 5: Circular Buffer
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("\\nBuffer after 1,2,3: " + buffer.getBuffer());
        buffer.insert(4);
        System.out.println("Buffer after inserting 4: " + buffer.getBuffer());
    }
}