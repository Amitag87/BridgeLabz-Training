package BridgeLab;
import java.util.*;
public class FeetToYard {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int feet=sc.nextInt();
	int yard=feet/3;
	int mile=yard/1760;
	System.out.println("The distance in feet, yard, mile is "+feet +", "+yard+" ,"+mile);
	
}
}
