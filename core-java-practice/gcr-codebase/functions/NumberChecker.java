package functions;

import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;

        if (number == 0) {
            digits[0] = 0;
            return digits;
        }

        while (number != 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits) {
        int power = digits.length;
        int sum = 0;
        int number = 0;

        for (int d : digits) {
            number = number * 10 + d;
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println(countDigits(number));
        System.out.println(isDuckNumber(digits));
        System.out.println(isArmstrongNumber(digits));

        int[] max = findLargestAndSecondLargest(digits);
        System.out.println(max[0] + " " + max[1]);

        int[] min = findSmallestAndSecondSmallest(digits);
        System.out.println(min[0] + " " + min[1]);

        sc.close();
    }
}
