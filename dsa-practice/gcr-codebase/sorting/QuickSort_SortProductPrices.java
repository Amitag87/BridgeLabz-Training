public class QuickSort_SortProductPrices {
    public static void main(String[] args) {
        int[] productPrices = {450, 200, 350, 100, 500, 150, 300};
        System.out.println("Product Prices before Sorting:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("\nProduct Prices after Sorting:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
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
