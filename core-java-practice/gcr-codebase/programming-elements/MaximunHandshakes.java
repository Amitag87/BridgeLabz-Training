package BridgeLab;
import java.util.*;
public class MaximunHandshakes {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int totalHandshake=(n*(n-1))/2;
	System.out.println("Total no. of handshakes "+totalHandshake);
}
}
