import java.util.Scanner;
class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int number=sc.nextInt();
        int temp=number;
        int count=0;
        if (temp == 0) {
            count =1;
        } 
        else{
            while(temp != 0) {
                count++;
                temp = temp / 10;
            }
        }
        int[] digits = new int[count];
        temp=number;
        int index= 0;
        if (temp == 0) {
            digits[index] = 0;
            index++;
        } else {
            while (temp != 0) {
                digits[index] = temp % 10;
                temp = temp / 10;
                index++;
            }
        }
        int[] freq= new int[10];
        for (int i =0; i<index;i++) {
            freq[digits[i]]++;
        }
        for (int i = 0; i <10; i++) {
            if (freq[i]> 0) {
                System.out.println("Digit "+i +" frequency is "+ freq[i]);
            }
        }
    }
}
