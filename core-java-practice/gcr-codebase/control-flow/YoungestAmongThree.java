import java.util.Scanner;
public class YoungestAmongThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();
        
        int amarHeight = sc.nextInt();
        int akbarHeight = sc.nextInt();
        int anthonyHeight = sc.nextInt();

        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            System.out.println("The youngest age is: " + amarAge);
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            System.out.println("The youngest age is: " + akbarAge);
        } else {
            System.out.println("The youngest age is: " + anthonyAge);
        }

        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            System.out.println("The tallest height is: " + amarHeight);
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            System.out.println("The tallest height is: " + akbarHeight);
        } else {
            System.out.println("The tallest height is: " + anthonyHeight);
        }
    }
}
