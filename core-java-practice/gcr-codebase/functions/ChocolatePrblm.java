package functions;

import java.util.Scanner;

public class ChocolatePrblm {
public static void main(String[] args) {
	Scanner sc=new  Scanner(System.in);
	int numChoc=sc.nextInt();
	int numChild=sc.nextInt();
	numChocs(numChoc,numChild);
}
public static void numChocs(int n,int m) {
	System.out.println(n/m);
	System.out.println(n%m);
}
}
