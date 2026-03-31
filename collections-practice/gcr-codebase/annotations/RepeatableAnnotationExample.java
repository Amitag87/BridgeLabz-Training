import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BuggyClass {
    @BugReport(description = "Memory leak in loop")
    @BugReport(description = "Null pointer exception possible")
    public void problematicMethod() {
        System.out.println("This method has known issues");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = BuggyClass.class;
        Method method = clazz.getMethod("problematicMethod");
        
        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
        
        System.out.println("Bug reports for " + method.getName() + ":");
        for (BugReport report : bugReports) {
            System.out.println("- " + report.description());
        }
    }
}