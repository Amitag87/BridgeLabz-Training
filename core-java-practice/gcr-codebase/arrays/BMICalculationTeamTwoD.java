import java.util.Scanner;
class BMMICalculationTeamTwoD{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        double[][] personData = new double[num][3];
        String[] weightStatus = new String[num];
        for (int i = 0; i<num; i++) {
            double wt =sc.nextDouble();
            double ht= sc.nextDouble();
            if (wt <= 0 || ht <= 0) {
                i--;
                continue;
            }
            personData[i][0] =wt;
            personData[i][1]=ht;
        }
        for (int i = 0; i < num; i++) {
            double hMeter = personData[i][1]/100;
            double bmi=personData[i][0]/(hMeter * hMeter);
            personData[i][2]=bmi;
            if (bmi <= 18.4) {
                weightStatus[i] ="Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i]= "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i]= "Overweight";
            } else {
                weightStatus[i] ="Obese";
            }
        }
        for (int i=0;i<num;i++) {
            System.out.println("Height " + personData[i][1] + " Weight " +personData[i][0]+" BMI " + personData[i][2]+" Status " + weightStatus[i]);
        }
    }
}
