import java.util.Scanner;
class PosNegOrZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numArray = new int[5];
        for (int i = 0; i < 5; i++) {
            numArray[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (numArray[i] > 0) {
                if(numArray[i]%2==0){
                    System.out.println(numArray[i] + " is Positive Even Number");
                } else {
                    System.out.println(numArray[i] + " is Positive Odd Number");
                }
            } else if (numArray[i] < 0) {
                System.out.println(numArray[i] + " is Negative");
            } else {
                System.out.println(numArray[i] + " is Zero");
            }
        }
        if(numArray[0]==numArray[numArray.length-1]){
            System.out.println("First and Last elements are equal");
        }
        else if(numArray[0] > numArray[numArray.length - 1]){
            System.out.println("First is greater than Last");
        }
        else {
            System.out.println("Last is greater than First");
        }
    }
}