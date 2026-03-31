import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectManager {
    @Todo(task = "Implement user authentication", assignedTo = "John", priority = "HIGH")
    public void setupAuth() {
        System.out.println("Auth setup - TODO");
    }
    
    @Todo(task = "Add database connection", assignedTo = "Alice")
    public void setupDatabase() {
        System.out.println("Database setup - TODO");
    }
    
    @Todo(task = "Write unit tests", assignedTo = "Bob", priority = "LOW")
    public void writeTests() {
        System.out.println("Tests - TODO");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        Class<?> clazz = ProjectManager.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned to: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("---");
            }
        }
    }
}