package review;
class A{
    void methodA(){
        System.out.println("Method from class A");
    }
}
class B{
    void methodb(){
        System.out.println("Method from class B");
    }
}
class C extends A{
    void methodC(){
        System.out.println("Method from class C extending A");
    }
}
class C extends B{
    void methodC(){
        System.out.println("Method from class C extending B");
    }
}
public class MultipleInheritance {
    public static void main(String[] args) {
        C c = new C();
        c.methodC();
    }
}
