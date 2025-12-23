package scenariobased;

import java.util.Scanner;

public class ElectionBoothManager {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the age");
		int age=sc.nextInt();
		while(true) {
		if(age<18) {
			System.out.println("You cannot vote");
			return;
		}
		System.out.println("Enter 1 to vote: Bhajan Lal Sharma Party BJP");
		System.out.println("Enter 2 to vote: Ashok Gahlot Party INC");
		System.out.println("Enter 3 to vote: Rajendra Meena RLP");
		System.out.println("Enter 4 to vote: NOTA");
		int val=sc.nextInt();
		switch(val) {
		case 1:
			System.out.println("Voted: Bhajan Lal Sharma Party BJP");
			System.out.println("Thanks or voting");
			break;
		case 2:
			System.out.println("Voted: Ashok Gahlot Party INC");
			System.out.println("Thanks or voting");
			break;
		case 3:
			System.out.println("Voted: Rajendra Meena RLP");
			System.out.println("Thanks or voting");
			break;
		case 4:
			System.out.println("Voted NOTA");
			System.out.println("Thanks or voting");
			break;
		}
		System.out.println("Is there more candidates to vote ?Type Yes or No");
		String voteAgain=sc.next();
		if(voteAgain.equals("No")) {
			System.out.println("Thanks or voting");
			return;
		}
		}
		
		
	}

}
