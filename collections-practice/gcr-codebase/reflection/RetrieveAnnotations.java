import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class BookClass {
    public void displayInfo() {
        System.out.println("This is a book class");
    }
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        Class<?> clazz = BookClass.class;
        
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No Author annotation found");
        }
    }
}