import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

interface DatabaseService {
    void connect();
}

class MySQLService implements DatabaseService {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }
}

class UserService {
    @Inject
    private DatabaseService databaseService;
    
    public void performOperation() {
        if (databaseService != null) {
            databaseService.connect();
            System.out.println("User operation performed");
        } else {
            System.out.println("Database service not injected");
        }
    }
}

public class DependencyInjection {
    private static Map<Class<?>, Object> dependencies = new HashMap<>();
    
    static {
        dependencies.put(DatabaseService.class, new MySQLService());
    }
    
    public static void inject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = dependencies.get(field.getType());
                if (dependency != null) {
                    field.set(obj, dependency);
                    System.out.println("Injected " + field.getType().getSimpleName() + " into " + field.getName());
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        inject(userService);
        userService.performOperation();
    }
}