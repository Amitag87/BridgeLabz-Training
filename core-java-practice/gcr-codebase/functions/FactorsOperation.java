package functions;

import java.util.Scanner;

public class FactorsOperation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int factors[]=findfactors(n);
		System.out.println("The sum of factors is : "+sum(factors));
		System.out.println("The sum of sq of factors is : "+sqsum(factors));
	}
	public static int[] findfactors(int n) {
		
		int index=0 , c=0;
		int factors[]=new int[n];
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				c++;
			}
		}
		for(int i=1;i<=n;i++) {
			if (n % i == 0) {
                factors[index++] = i;
            }
		}
		return factors;
	}
	public static int sum(int[] factors) {
		int sum=0;
		for(int f:factors) {
			sum+=f;
		}
		return sum;
	}
	public static int sqsum(int[] factors) {
		int sq=1;
		for(int f:factors) {
			sq+=(f*f);
		}
		return sq;
	}
	
}
