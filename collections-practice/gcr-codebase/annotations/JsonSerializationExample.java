import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name() default "";
}

class User {
    @JsonField(name = "user_name")
    private String username = "john_doe";
    
    @JsonField(name = "user_age")
    private int age = 25;
    
    @JsonField
    private String email = "john@example.com";
    
    private String password = "secret"; // Not annotated, won't be serialized
}

public class JsonSerializationExample {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        StringBuilder json = new StringBuilder("{");
        boolean first = true;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField jsonField = field.getAnnotation(JsonField.class);
                
                String fieldName = jsonField.name().isEmpty() ? field.getName() : jsonField.name();
                Object value = field.get(obj);
                
                if (!first) json.append(",");
                
                json.append("\"").append(fieldName).append("\":");
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                
                first = false;
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) throws Exception {
        User user = new User();
        String json = toJson(user);
        System.out.println("JSON representation: " + json);
    }
}