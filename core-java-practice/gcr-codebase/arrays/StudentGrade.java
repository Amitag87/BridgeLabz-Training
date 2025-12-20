import java.util.Scanner;

class StudentGrade{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int students=sc.nextInt();
        double[] physics= new double[students];
        double[] chemistry =new double[students];
        double[] maths= new double[students];
        double[] percentage= new double[students];
        String[] grade =new String[students];
        for (int i=0;i<students;i++) {
            double p=sc.nextDouble();
            double c=sc.nextDouble();
            double m =sc.nextDouble();
            if (p< 0|| c< 0|| m< 0) {
                i--;
                continue;
            }
            physics[i] = p;
            chemistry[i]= c;
            maths[i]= m;
        }
        for (int i = 0; i < students; i++) {
            percentage[i]= (physics[i] +chemistry[i] +maths[i]) / 3;
            if (percentage[i] >= 80) {
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] ="B";
            } else if (percentage[i] >= 60) {
                grade[i]= "C";
            } else if (percentage[i] >= 50) {
                grade[i] ="D";
            } else if (percentage[i] >= 40) {
                grade[i] ="E";
            } else {
                grade[i] ="R";
            }
        }
        for (int i = 0; i < students; i++) {
            System.out.println("Physics " + physics[i] +" Chemistry " +chemistry[i] +" Maths " +maths[i] +" Percentage " +percentage[i] +" Grade " +grade[i]);
        }
    }
}
