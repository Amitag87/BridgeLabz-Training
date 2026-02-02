import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method executed");
    }
    
    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(100);
            System.out.println("Slow method executed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class LogExecutionTimeExample {
    public static void executeWithTiming(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            
            double executionTime = (endTime - startTime) / 1000000.0;
            System.out.println("Execution time for " + methodName + ": " + executionTime + " ms");
        } else {
            method.invoke(obj);
        }
    }
    
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        
        executeWithTiming(test, "fastMethod");
        executeWithTiming(test, "slowMethod");
    }
}