import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceAnalysis {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000};
        
        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);
            
            // Test Bubble Sort
            int[] data1 = generateRandomArray(size);
            long start = System.nanoTime();
            bubbleSort(data1.clone());
            long bubbleTime = System.nanoTime() - start;
            
            // Test Merge Sort
            int[] data2 = data1.clone();
            start = System.nanoTime();
            mergeSort(data2, 0, data2.length - 1);
            long mergeTime = System.nanoTime() - start;
            
            // Test Quick Sort
            int[] data3 = data1.clone();
            start = System.nanoTime();
            quickSort(data3, 0, data3.length - 1);
            long quickTime = System.nanoTime() - start;
            
            System.out.println("Bubble Sort: " + bubbleTime / 1000000 + " ms");
            System.out.println("Merge Sort:  " + mergeTime / 1000000 + " ms");
            System.out.println("Quick Sort:  " + quickTime / 1000000 + " ms");
        }
    }
    
    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
    
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
    
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}