import java.util.*;

public class DataStructureSearchAnalysis {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        
        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);
            
            // Prepare data
            Integer[] array = generateData(size);
            HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(array));
            TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(array));
            
            int target = array[size / 2]; // Middle element
            
            // Array search (Linear)
            long start = System.nanoTime();
            boolean arrayFound = arraySearch(array, target);
            long arrayTime = System.nanoTime() - start;
            
            // HashSet search
            start = System.nanoTime();
            boolean hashFound = hashSet.contains(target);
            long hashTime = System.nanoTime() - start;
            
            // TreeSet search
            start = System.nanoTime();
            boolean treeFound = treeSet.contains(target);
            long treeTime = System.nanoTime() - start;
            
            System.out.println("Array Search:   " + arrayTime / 1000 + " μs");
            System.out.println("HashSet Search: " + hashTime / 1000 + " μs");
            System.out.println("TreeSet Search: " + treeTime / 1000 + " μs");
            System.out.println("Array vs HashSet: " + (arrayTime / (double) hashTime) + "x slower");
            System.out.println("TreeSet vs HashSet: " + (treeTime / (double) hashTime) + "x slower");
        }
    }
    
    static Integer[] generateData(int size) {
        Integer[] data = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 2);
        }
        return data;
    }
    
    static boolean arraySearch(Integer[] array, int target) {
        for (int value : array) {
            if (value == target) return true;
        }
        return false;
    }
}