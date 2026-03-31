import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello(String name);
    void sayGoodbye(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    @Override
    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }
}

class LoggingHandler implements InvocationHandler {
    private Object target;
    
    public LoggingHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Method " + method.getName() + " called");
        Object result = method.invoke(target, args);
        System.out.println("Logging: Method " + method.getName() + " completed");
        return result;
    }
}

public class CustomLoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingHandler(greeting)
        );
        
        proxy.sayHello("Alice");
        proxy.sayGoodbye("Bob");
    }
}