import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		while(true) {
			String coffeeType = sc.next();
			if(coffeeType.equals("exit")) {
				break;
			}
			int quantity = sc.nextInt();
			double price=0.0;
			switch (coffeeType) {
			case "Latte":
				price=200;
				System.out.println("Latte selected. Total Bill: " + (quantity*price+(price*0.18)));
				break;

			case "Cappuccino":
				price=100;
				System.out.println("Cappuccino selected. Bil: " + (quantity*price+(price*0.18)));
				break;
			case "Mocha":
				price=250;
				System.out.println("Mocha selected. Bill: " + (quantity*price+(price*0.18)));
				break;
			case "Espresso":
				price=150;
				System.out.println("Espresso selected. Bill: " + (quantity*price+(price*0.18)));
				break;
			case "Americano":
				price=300;
				System.out.println("Americano selected. Bill: " + (quantity*price+(price*0.18)));
				break;

			default:
				System.out.println("Invalid coffee type");
				continue;
				
			}
			System.out.println("For more coffee type it's name otherwise type exit");
		}

	}
}
