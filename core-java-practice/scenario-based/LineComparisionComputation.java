package scenariobased;

import java.util.Scanner;

public class LineComparisionComputation {
	public static void main(String[] args) {
//		Let us start our code
		System.out.println("Welcome to the Line Computation Program");
		Scanner sc=new Scanner(System.in);
//		uc1
		System.out.println("Input first coordinate");
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		System.out.println("Input second coordinate");
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		int length=(int)Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
		System.out.println("Length of a line is: "+length);
		System.out.println("Give coordinates of another line");
		System.out.println("Input first Line coordinates");
//		uc2
		int x3=sc.nextInt();
		int y3=sc.nextInt();
		System.out.println("Input second Line coordinates");
		int x4=sc.nextInt();
		int y4=sc.nextInt();	
		int length1=(int)Math.sqrt(Math.pow((x4-x3),2) + Math.pow((y4-y3),2));
		System.out.println("Length of another line: "+length1);
//		uc3 
		compare(length,length1);
	}
	public static void compare(int length, int length1) {
		if(length>length1) {
			System.out.println("Length of first line is greater than the second line");
		}
		else if(length<length1) {
			System.out.println("Length of first line is smaller than the second line");
		}
		else {
			System.out.println("Length of first line is equals to the second line");
		}
		
	}
}
