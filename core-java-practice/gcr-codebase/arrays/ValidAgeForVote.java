import java.util.Scanner;
class ValidAgeForVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ageArray = new int[10];
        for(int i=0; i<10; i++){
            ageArray[i] = sc.nextInt();
        }
        for(int i=0; i<10; i++){
            if(ageArray[i] >= 18){
                System.out.println("The student with the age "+ageArray[i]+" can vote");
            } else if(ageArray[i]>0 && ageArray[i]<18){
                System.out.println("The student with the age "+ageArray[i]+" cannot vote");
            }
            else {
                System.out.println("Invalid Age: ");
            }
        }
    }
}