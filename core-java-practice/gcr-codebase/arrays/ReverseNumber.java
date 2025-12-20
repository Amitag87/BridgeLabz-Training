import java.util.Scanner;
class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int noOfDigits = 0;
        int temp = number;
        if (number == 0) {
            noOfDigits = 1;
        }
        else{
            while (temp != 0) {
                noOfDigits++;
                temp = temp / 10;
            }
        }
        int[] reverse = new int[noOfDigits];
        for (int i = 0; i < noOfDigits; i++) {
            reverse[i] = number % 10;
            number = number / 10;
        }
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i]);
        }
    }
}
