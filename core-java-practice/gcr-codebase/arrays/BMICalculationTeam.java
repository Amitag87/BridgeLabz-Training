import java.util.Scanner;
class BMICalculationTeam{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int persons = sc.nextInt();
        double[] weight = new double[persons];
        double[] height = new double[persons];
        double[] bmi = new double[persons];
        String[] status = new String[persons];
        for (int i = 0; i < persons; i++) {
            weight[i] = sc.nextDouble();
            height[i] = sc.nextDouble();
        }
        for (int i = 0; i<persons;i++) {
            double hMeter = height[i] / 100;
            bmi[i] = weight[i] / (hMeter * hMeter);
            if (bmi[i] <= 18.4) {
                status[i]= "Underweight";
            } else if(bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if(bmi[i] <=39.9) {
                status[i] = "Overweight";
            } else{
                status[i]="Obese";
            }
        }
        for (int i=0;i< persons;i++) {
            System.out.println("Height " + height[i]+" Weight " + weight[i]+" BMI " + bmi[i]+" Status " + status[i]);
        }
    }
}
