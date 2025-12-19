import java.util.Scanner;

public class RocketLaunch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num>1) {
			System.out.println(num);
			num--;
		}
	}
}
