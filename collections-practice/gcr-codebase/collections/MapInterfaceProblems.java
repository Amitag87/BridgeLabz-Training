import java.util.*;

class Employee {
    String name;
    String department;
    
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class MapInterfaceProblems {
    
    // 1. Word Frequency Counter
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> frequency = new HashMap<>();
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        return frequency;
    }
    
    // 2. Invert a Map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return inverted;
    }
    
    // 3. Find Key with Highest Value
    public static String findMaxValueKey(Map<String, Integer> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    
    // 4. Merge Two Maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return merged;
    }
    
    // 5. Group Objects by Property
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        return grouped;
    }
    
    public static void main(String[] args) {
        // Test 1: Word Frequency
        String text = "Hello world, hello Java!";
        System.out.println("Text: " + text);
        System.out.println("Word Frequency: " + wordFrequency(text));
        
        // Test 2: Invert Map
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);
        System.out.println("\\nOriginal Map: " + original);
        System.out.println("Inverted Map: " + invertMap(original));
        
        // Test 3: Max Value Key
        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 10);
        scores.put("B", 20);
        scores.put("C", 15);
        System.out.println("\\nScores: " + scores);
        System.out.println("Highest score key: " + findMaxValueKey(scores));
        
        // Test 4: Merge Maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        
        System.out.println("\\nMap1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged: " + mergeMaps(map1, map2));
        
        // Test 5: Group by Department
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        System.out.println("\\nEmployees: " + employees);
        System.out.println("Grouped by Department: " + groupByDepartment(employees));
    }
}