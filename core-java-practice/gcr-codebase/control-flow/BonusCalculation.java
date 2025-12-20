import java.util.Scanner;
class BonusCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
<<<<<<< HEAD
        int years = sc.nextInt();
=======
        int years = scn.nextInt();
>>>>>>> 62de6c3a8e096b275783d007858d7866da02ce12
        double bonusPercent = 0;
        if (years > 5) {
            bonusPercent = 5;
        }
        double bonusAmount = (salary * bonusPercent) / 100;
        System.out.println("The bonus amount is " + bonusAmount);
    }
}
