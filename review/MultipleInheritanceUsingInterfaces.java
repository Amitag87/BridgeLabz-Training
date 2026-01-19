
interface A{
    void print();
}
interface B{
    void print();
}
interface C extends A, B{
    void display();
}

public class MultipleInheritanceUsingInterfaces {
    public static void main(String[] args) {
        C obj = new C() {

            @Override
            public void print() {
                System.out.println("Print method from both A and B interfaces");
            }

            @Override
            public void display() {
                System.out.println("Display method from C interface");
            }
        };
        obj.print();
        obj.display();
    }
}
