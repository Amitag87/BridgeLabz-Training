import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;
    
    @MaxLength(50)
    private String email;
    
    public User(String username, String email) throws Exception {
        validateFields(username, email);
        this.username = username;
        this.email = email;
    }
    
    private void validateFields(String username, String email) throws Exception {
        Field[] fields = this.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                String value = null;
                
                if (field.getName().equals("username")) {
                    value = username;
                } else if (field.getName().equals("email")) {
                    value = email;
                }
                
                if (value != null && value.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        field.getName() + " exceeds maximum length of " + maxLength.value()
                    );
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "'}";
    }
}

public class MaxLengthValidationExample {
    public static void main(String[] args) {
        try {
            User user1 = new User("john", "john@example.com");
            System.out.println("Valid user: " + user1);
            
            User user2 = new User("verylongusername", "test@example.com");
            System.out.println("This shouldn't print");
            
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}