import java.util.Scanner;
class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 6; i <= 9; i++) {
            int result = number * i;
            System.out.println(number+" * " +i+" = "+result);
        }
    }
}
