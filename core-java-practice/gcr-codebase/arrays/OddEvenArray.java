import java.util.Scanner;
class OddEvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num <= 0){
            System.out.println("Invalid input");
            return;
        }
        int[] even = new int[num / 2 + 1];
        int[] odd = new int[num / 2 + 1];
        int evenIndex =0;
        int oddIndex =0;
        for (int i =1; i<=num;i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }
        for (int i =0; i<oddIndex; i++) {
            System.out.println(odd[i]);
        }
        for (int i = 0; i< evenIndex; i++) {
            System.out.println(even[i]);
        }
    }
}
