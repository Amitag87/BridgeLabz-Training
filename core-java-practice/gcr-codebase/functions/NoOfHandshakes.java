package functions;

import java.util.Scanner;

public class NoOfHandshakes {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println(handshakes(n));
	
	}
	public static int handshakes(int n) {
		int maxHandshake=(n*(n-1))/2;
		return maxHandshake;
	}
}
