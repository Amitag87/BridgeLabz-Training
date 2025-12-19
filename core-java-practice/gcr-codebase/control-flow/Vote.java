
import java.util.*;
public class Vote {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int age=sc.nextInt();
		if(age>=18) {
			System.out.println("The person of "+ age +"can vote");
		}
		else {
			System.out.println("The person cannot vote");
		}
		sc.close();
	}
}
