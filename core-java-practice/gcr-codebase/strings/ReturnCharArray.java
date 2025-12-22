package strings;

import java.util.Scanner;

public class ReturnCharArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String str = sc.next();

       
        char[] userChars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            userChars[i] = str.charAt(i);
        }

      
        char[] builtInChars = str.toCharArray();


        if (userChars.length != builtInChars.length) {
            System.out.println("Not Equal");
            return;
        }

        for (int i = 0; i < userChars.length; i++) {
            if (userChars[i] != builtInChars[i]) {
                System.out.println("Not Equal");
                return;
            }
        }

        
        System.out.println("Equal");
    }
}
