import java.util.Scanner;
class StudentGradeTwoD{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        double[][] marks = new double[students][3];
        double[] percentage = new double[students];
        String[] grade = new String[students];
        for (int i = 0; i < students; i++) {
            double p = sc.nextDouble();
            double c = sc.nextDouble();
            double m = sc.nextDouble();
            if (p < 0 || c < 0 || m < 0) {
                i--;
                continue;
            }
            marks[i][0] =p;
            marks[i][1]=c;
            marks[i][2]=m;
        }
        for (int i = 0; i < students; i++) {
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;
            if (percentage[i] >= 80){
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] ="B";
            } else if (percentage[i]>= 60) {
                grade[i] = "C";
            } else if (percentage[i]>= 50) {
                grade[i] = "D";
            } else if (percentage[i]>= 40) {
                grade[i]= "E";
            } else {
                grade[i] ="R";
            }
        }
        for (int i = 0; i < students; i++) {
            System.out.println("Physics " + marks[i][0] +" Chemistry " + marks[i][1] +" Maths " + marks[i][2] +" Percentage " + percentage[i] +" Grade " + grade[i]);
        }
    }
}
