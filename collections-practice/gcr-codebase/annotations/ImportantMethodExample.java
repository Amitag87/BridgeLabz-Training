import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class BusinessLogic {
    @ImportantMethod
    public void processPayment() {
        System.out.println("Processing payment");
    }
    
    @ImportantMethod(level = "CRITICAL")
    public void validateSecurity() {
        System.out.println("Validating security");
    }
    
    public void regularMethod() {
        System.out.println("Regular method");
    }
}

public class ImportantMethodExample {
    public static void main(String[] args) {
        Class<?> clazz = BusinessLogic.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        System.out.println("Important methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " - Level: " + annotation.level());
            }
        }
    }
}