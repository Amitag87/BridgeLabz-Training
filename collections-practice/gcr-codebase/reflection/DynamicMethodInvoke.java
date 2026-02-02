import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int mul(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvoke {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter method name (add/sub/mul): ");
        String methodName = sc.next();

        MathOperations obj = new MathOperations();

        Method method = MathOperations.class
                .getMethod(methodName, int.class, int.class);

        int result = (int) method.invoke(obj, 10, 5);
        System.out.println("Result: " + result);
    }
}
