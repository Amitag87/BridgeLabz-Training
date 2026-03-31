public class BinarySearchFirstLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        
        System.out.println("First occurrence of " + target + ": " + first);
        System.out.println("Last occurrence of " + target + ": " + last);
    }
    
    static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}