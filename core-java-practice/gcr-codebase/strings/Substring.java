package strings;

import java.util.Scanner;

public class Substring {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        String result = "";

        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
//        return result;
        System.out.println(result);
        
        
	}
}
