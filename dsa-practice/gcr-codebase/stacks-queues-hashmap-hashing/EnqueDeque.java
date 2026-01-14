import java.util.Stack;

class EnqueDeque {
    public static void main(String[] args) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        enqueue(10,s1);
        dequeue(s1,s2);
        
    }
  
static void enqueue(int data , Stack<Integer> s1){
    s1.push(data);
}
static void dequeue(Stack<Integer> s1, Stack<Integer> s2){
    if(s1.isEmpty()){
        System.out.println("Queue is empty");
    }
    else{
        while(!s1.isEmpty()){
            int x=s1.pop();
            System.out.println("popped element is: "+x);          
            s2.push(x);
        }
        while(!s2.isEmpty()){
            int x=s2.pop();
             System.out.println("popped element is: "+x); 
            s1.push(x);           
        }
    }
}
}
