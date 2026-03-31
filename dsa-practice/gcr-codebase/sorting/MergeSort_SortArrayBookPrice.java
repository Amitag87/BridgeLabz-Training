public class MergeSort_SortArrayBookPrice {
    public static void main(String[] args) {
        int bookPrices[] = {200, 150, 300, 100, 250};
        int n = bookPrices.length;
        System.out.println("Book Prices before Sorting: ");
        for (int price : bookPrices) {
            System.out.println(price);
        }
        System.out.println("Book Prices after Sorting: ");
        mergeSort(bookPrices, 0, n - 1);
        for (int price : bookPrices) {
            System.out.println(price);
        }
    }

    public static void mergeSort(int bookPrices[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(bookPrices, low, mid);
            mergeSort(bookPrices, mid + 1, high);
            merge(bookPrices, low, mid, high);
        }
    }

    public static void merge(int bookPrices[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = bookPrices[low + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = bookPrices[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                bookPrices[k] = leftArray[i];
                i++;
            } else {
                bookPrices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            bookPrices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            bookPrices[k] = rightArray[j];
            j++;
            k++;
        }
    }
}