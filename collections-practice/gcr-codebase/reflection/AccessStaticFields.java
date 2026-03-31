import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "default-key-123";
    
    public static String getApiKey() {
        return API_KEY;
    }
}

public class AccessStaticFields {
    public static void main(String[] args) throws Exception {
        System.out.println("Original API_KEY: " + Configuration.getApiKey());
        
        Class<?> clazz = Configuration.class;
        Field field = clazz.getDeclaredField("API_KEY");
        field.setAccessible(true);
        
        field.set(null, "new-secret-key-456");
        
        System.out.println("Modified API_KEY: " + Configuration.getApiKey());
    }
}