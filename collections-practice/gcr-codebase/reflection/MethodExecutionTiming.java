import java.lang.reflect.Method;

class Calculator {
    public int slowAdd(int a, int b) {
        try {
            Thread.sleep(100); // Simulate slow operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return a + b;
    }
    
    public int fastMultiply(int a, int b) {
        return a * b;
    }
    
    public void processData() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Data processed");
    }
}

public class MethodExecutionTiming {
    public static void measureExecutionTime(Object obj, String methodName, Class<?>[] paramTypes, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, paramTypes);
        
        long startTime = System.nanoTime();
        Object result = method.invoke(obj, args);
        long endTime = System.nanoTime();
        
        long duration = endTime - startTime;
        System.out.println("Method: " + methodName);
        System.out.println("Execution time: " + duration / 1000000.0 + " ms");
        if (result != null) {
            System.out.println("Result: " + result);
        }
        System.out.println("---");
    }
    
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        
        measureExecutionTime(calc, "slowAdd", new Class[]{int.class, int.class}, 5, 3);
        measureExecutionTime(calc, "fastMultiply", new Class[]{int.class, int.class}, 4, 7);
        measureExecutionTime(calc, "processData", new Class[]{});
    }
}