package scenariobased;

import java.util.Scanner;

public class MetroSmartCardFareDeduction {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the distance you want to travel");
		int dist=sc.nextInt();
		int balance=1000;
		int fare = (30 > dist) ? 30 : (dist<60) ? 1*dist : 60 ;
		System.out.println("Your fare is: "+fare);
		System.out.println("Current balance is: "+(balance-fare));
	}

}
