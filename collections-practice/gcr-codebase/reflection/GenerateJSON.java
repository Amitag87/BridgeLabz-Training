import java.lang.reflect.Field;

class Student {
    private String name = "John Doe";
    private int age = 20;
    private double gpa = 3.8;
    private boolean isActive = true;
}

public class GenerateJSON {
    public static String toJSON(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        StringBuilder json = new StringBuilder("{");
        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            
            Object value = field.get(obj);
            json.append("\"").append(field.getName()).append("\":");
            
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }
            
            if (i < fields.length - 1) {
                json.append(",");
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        String json = toJSON(student);
        System.out.println("JSON representation: " + json);
    }
}