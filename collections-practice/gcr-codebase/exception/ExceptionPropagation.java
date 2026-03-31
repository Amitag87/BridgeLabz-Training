public class ExceptionPropagation {
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }
    
    public static void method2() {
        method1(); // Exception propagates from method1 to method2
    }
    
    public static void main(String[] args) {
        try {
            method2(); // Exception propagates from method2 to main
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}