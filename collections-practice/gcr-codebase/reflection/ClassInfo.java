import java.lang.reflect.*;
public class ClassInfo {
    public static void main(String[] args) throws Exception {
        String className="java.util.ArrayList";
        Class<?> c=Class.forName(className);
        System.out.println("Class Name: " + c.getName());
        System.out.println("Methods are:-");
        for(Method m : c.getDeclaredMethods()){
            System.out.println(m.getName());
        }
        System.out.println("fields are:-");
        for(Field f : c.getDeclaredFields()){
            System.out.println(f.getName());

        }
        System.out.println("Constructors are:-");
        for(Constructor<?> cons:c.getDeclaredConstructors()){
            System.out.println(cons);
        }


    }
}
