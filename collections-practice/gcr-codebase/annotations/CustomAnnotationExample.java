import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority() default "MEDIUM";
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "John")
    public void criticalTask() {
        System.out.println("Executing critical task");
    }
    
    @TaskInfo(assignedTo = "Alice")
    public void normalTask() {
        System.out.println("Executing normal task");
    }
}

public class CustomAnnotationExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = TaskManager.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned to: " + taskInfo.assignedTo());
                System.out.println("---");
            }
        }
    }
}