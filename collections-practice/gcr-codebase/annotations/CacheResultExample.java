import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveCalculator {
    private static Map<String, Object> cache = new HashMap<>();
    
    @CacheResult
    public long fibonacci(int n) {
        System.out.println("Computing fibonacci(" + n + ")");
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    @CacheResult
    public int factorial(int n) {
        System.out.println("Computing factorial(" + n + ")");
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static Object executeWithCache(Object obj, String methodName, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, getParameterTypes(args));
        
        if (method.isAnnotationPresent(CacheResult.class)) {
            String cacheKey = methodName + ":" + java.util.Arrays.toString(args);
            
            if (cache.containsKey(cacheKey)) {
                System.out.println("Cache hit for " + cacheKey);
                return cache.get(cacheKey);
            }
            
            Object result = method.invoke(obj, args);
            cache.put(cacheKey, result);
            System.out.println("Cached result for " + cacheKey);
            return result;
        }
        
        return method.invoke(obj, args);
    }
    
    private static Class<?>[] getParameterTypes(Object... args) {
        Class<?>[] types = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
            if (types[i] == Integer.class) types[i] = int.class;
        }
        return types;
    }
}

public class CacheResultExample {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calc = new ExpensiveCalculator();
        
        System.out.println("First call:");
        Object result1 = ExpensiveCalculator.executeWithCache(calc, "factorial", 5);
        System.out.println("Result: " + result1);
        
        System.out.println("\\nSecond call (should use cache):");
        Object result2 = ExpensiveCalculator.executeWithCache(calc, "factorial", 5);
        System.out.println("Result: " + result2);
        
        System.out.println("\\nDifferent parameter:");
        Object result3 = ExpensiveCalculator.executeWithCache(calc, "factorial", 6);
        System.out.println("Result: " + result3);
    }
}