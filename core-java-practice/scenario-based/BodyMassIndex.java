/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class BodyMassIndex
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int weight=sc.nextInt();
		int height=sc.nextInt();
		int bmi=weight/(height*height);
		if(bmi<18.5){
		    System.out.print("Underweight");
		}
		else if(bmi<=24.9){
		    System.out.print("Normal");
		}
		else{
		    System.out.print("Overweight");
		}
	}
}
