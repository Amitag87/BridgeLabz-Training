import java.util.*;

public class Main {
    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        Node h1 = null, t1 = null;
        for (int i = 0; i < n1; i++) {
            Node x = new Node(sc.nextInt());
            if (h1 == null) h1 = t1 = x;
            else { t1.next = x; t1 = x; }
        }

        int n2 = sc.nextInt();
        Node h2 = null, t2 = null;
        for (int i = 0; i < n2; i++) {
            Node x = new Node(sc.nextInt());
            if (h2 == null) h2 = t2 = x;
            else { t2.next = x; t2 = x; }
        }

        Node p = h1, q = h2, head = null, tail = null;
        int carry = 0;

        while (p != null || q != null || carry != 0) {
            int sum = carry;
            if (p != null) { sum += p.val; p = p.next; }
            if (q != null) { sum += q.val; q = q.next; }

            Node z = new Node(sum % 10);
            carry = sum / 10;

            if (head == null) head = tail = z;
            else { tail.next = z; tail = z; }
        }

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
