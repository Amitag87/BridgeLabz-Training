import java.util.Scanner;

public class SpringSeason {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int date=sc.nextInt();
		int month=sc.nextInt();
		
			if(month==3 &&  date>=20) {
				System.out.println("It is a spring season");
			}
			else if(month==6 || date<=20) {
				System.out.println("its a spring season");
			}
			else if(month>3 && month<6) {
				System.out.println("its a spring season");
			}
			else {
				System.out.println("Not a spring seeason");
			}
		}
	}

