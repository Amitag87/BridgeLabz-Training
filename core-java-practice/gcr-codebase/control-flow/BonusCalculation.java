import java.util.Scanner;
class BonusCalculation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double salary = scn.nextDouble();
        int years = scn.nextInt();
        double bonusPercent = 0;
        if (years > 5) {
            bonusPercent = 5;
        }
        double bonusAmount = (salary * bonusPercent) / 100;
        System.out.println("The bonus amount is " + bonusAmount);
    }
}