import java.util.*;
public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //enter first word
        String str1=sc.next();
        if(str1.contains(" ")){
            System.out.println("word1 is invalid");
            return;
        }
        System.out.println("Enter the second word");
        String str2=sc.next();
        if(str2.contains(" ")){
            System.out.println("word2 is invalid");
            return;
        }
        String revWord1=new StringBuilder(str1).reverse().toString();
        if(revWord1.equalsIgnoreCase(str2)){
            String result=revWord1.toLowerCase();
            result=result.replaceAll("[aeiou]","@");
            System.out.println(result);
        }
        else{
            String str3= (str1+str2).toUpperCase();
            int vowelCount=0, consonantCount=0;
            String vowels="AEIOU";
            for(int i=0;i<str3.length();i++){
                char ch=str3.charAt(i);
                if(vowels.indexOf(ch)!=-1){
                    vowelCount++;
                }
                else if(Character.isLetter(ch)){
                    consonantCount++;
                }
            }
            
            if (vowelCount > consonantCount) {
                printFirstTwoUnique(combined, vowels);
            } 
            else if (consonantCount > vowelCount) {
                printFirstTwoUnique(combined, "BCDFGHJKLMNPQRSTVWXYZ");
            } 
            else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        sc.close();
    }

    // Helper method to print first 2 unique characters
    private static void printFirstTwoUnique(String text, String allowedChars) {
        String result = "";

        for (int i = 0; i < text.length() && result.length() < 2; i++) {
            char ch = text.charAt(i);
            if (allowedChars.indexOf(ch) != -1 &&
                result.indexOf(ch) == -1) {
                result += ch;
            }
        }

        System.out.println(result);
    }

        
    
}
