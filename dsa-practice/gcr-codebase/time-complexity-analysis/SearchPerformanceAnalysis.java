import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceAnalysis {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        
        for (int size : sizes) {
            int[] data = generateSortedArray(size);
            int target = data[size / 2]; // Middle element
            
            System.out.println("\nDataset Size: " + size);
            
            // Linear Search
            long start = System.nanoTime();
            int linearResult = linearSearch(data, target);
            long linearTime = System.nanoTime() - start;
            
            // Binary Search
            start = System.nanoTime();
            int binaryResult = binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;
            
            System.out.println("Linear Search: " + linearTime / 1000 + " μs");
            System.out.println("Binary Search: " + binaryTime / 1000 + " μs");
            System.out.println("Performance Ratio: " + (linearTime / (double) binaryTime) + "x faster");
        }
    }
    
    static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }
    
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}