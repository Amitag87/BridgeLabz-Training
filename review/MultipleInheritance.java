package review;
class A{
    void methodA(){
        System.out.println("Method from class A");
    }
}
class B{
    void methodA(){
        System.out.println("Method from class B");
    }
}
class C extends A,B{
    void methodA(){
        System.out.println("Method from class C extending A");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        C c = new C();
        c.methodA();
    }
}
