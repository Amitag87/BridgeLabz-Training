import java.util.Scanner;
class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        for (int i = 6; i <= 9; i++) {
            int result = number * i;
            System.out.println(number+" * " +i+" = "+result);
        }
    }
}
