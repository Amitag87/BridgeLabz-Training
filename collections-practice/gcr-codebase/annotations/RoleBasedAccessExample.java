import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully");
    }
    
    @RoleAllowed("USER")
    public void viewProfile() {
        System.out.println("Profile displayed");
    }
    
    public void publicMethod() {
        System.out.println("Public method - no role required");
    }
}

public class RoleBasedAccessExample {
    private static String currentUserRole = "USER";
    
    public static void executeWithRoleCheck(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();
            
            if (!currentUserRole.equals(requiredRole)) {
                System.out.println("Access Denied! Required role: " + requiredRole + ", Current role: " + currentUserRole);
                return;
            }
        }
        
        method.invoke(obj);
    }
    
    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        
        System.out.println("Current user role: " + currentUserRole);
        
        executeWithRoleCheck(service, "viewProfile");
        executeWithRoleCheck(service, "deleteUser");
        executeWithRoleCheck(service, "publicMethod");
        
        // Change role to ADMIN
        currentUserRole = "ADMIN";
        System.out.println("\\nChanged role to: " + currentUserRole);
        executeWithRoleCheck(service, "deleteUser");
    }
}