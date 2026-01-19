public class SecondLargestElement {
    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1};
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = number;
            } else if (number > secondLargest && number != firstLargest) {
                secondLargest = number;
            }
        }

        
            System.out.println("The second largest element is: " + secondLargest);
        
    }
}
