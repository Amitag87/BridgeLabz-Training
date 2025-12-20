<<<<<<< HEAD

=======
>>>>>>> 62de6c3a8e096b275783d007858d7866da02ce12

import java.util.Scanner;

public class CountdownForLoop {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num=sc.nextInt();
	for(int i=num;i>=1;i--) {
		System.out.println(i);
	}
	sc.close();
}
}
