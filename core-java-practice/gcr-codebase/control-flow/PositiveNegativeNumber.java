import java.util.*;
public class PositiveNegativeNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num<0) {
			System.out.println("negative");
		}
		else if(num>0) {
			System.out.println("positive");
		}
		else {
			System.out.println("zero");
		}
	}
}
