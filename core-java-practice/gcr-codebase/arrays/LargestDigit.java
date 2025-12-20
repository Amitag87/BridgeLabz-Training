import java.util.Scanner;
class LargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        if (num ==0) {
            digits[index] = 0;
            index++;
        }
        while (num !=0 && index< maxDigit) {
            digits[index] = num % 10;
            num = num/ 10;
            index++;
        }
        int largest= 0;
        int secondLargest = 0;
        for (int i =0;i <index;i++) {
            if (digits[i] >largest) {
                secondLargest =largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] < largest) {
                secondLargest =digits[i];
            }
        }
        System.out.println("Largest Digit = " +largest);
        System.out.println("Second Largest Digit = " +secondLargest);
    }
}
