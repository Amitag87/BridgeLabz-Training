package strings;

import java.util.Scanner;

public class StringComparision {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		if(str1.length()!=str2.length()) {
			System.out.println("Strings are not Equal");
			return;
		}
		
			for(int i=0;i<str1.length();i++) {
				if(str1.charAt(i)!=str2.charAt(i)){
					System.out.println("Strings are not Equal");
					return;
				}
			}
		
		System.out.println("Strings are Equal");
	}
}
