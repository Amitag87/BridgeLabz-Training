import java.util.*;

class Student {
    String name, dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Student> list = new ArrayList<>();

        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");

            if (input[0].equals("Record")) {
                String name = input[1];
                String dept = input[2];
                int q1 = Integer.parseInt(input[3]);
                int q2 = Integer.parseInt(input[4]);
                int q3 = Integer.parseInt(input[5]);

                list.add(new Student(name, dept, q1, q2, q3));
                System.out.println("Record Added: " + name);
            }

            else if (input[0].equals("Top")) {

                if (list.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                String param = input[1];

                // 🔹 Top by Department
                if (!param.startsWith("Q")) {
                    int max = Integer.MIN_VALUE;
                    boolean found = false;

                    for (Student s : list) {
                        if (s.dept.equals(param)) {
                            found = true;
                            max = Math.max(max, s.total());
                        }
                    }

                    if (!found) {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for (Student s : list) {
                        if (s.dept.equals(param) && s.total() == max) {
                            System.out.println(s.name + " " + max);
                        }
                    }
                }

                // 🔹 Top by Quiz
                else {
                    int idx = param.charAt(1) - '0'; // Q1, Q2, Q3
                    int max = Integer.MIN_VALUE;

                    for (Student s : list) {
                        if (idx == 1) max = Math.max(max, s.q1);
                        if (idx == 2) max = Math.max(max, s.q2);
                        if (idx == 3) max = Math.max(max, s.q3);
                    }

                    for (Student s : list) {
                        if ((idx == 1 && s.q1 == max) ||
                            (idx == 2 && s.q2 == max) ||
                            (idx == 3 && s.q3 == max)) {

                            int score = (idx == 1) ? s.q1 : (idx == 2 ? s.q2 : s.q3);
                            System.out.println(s.name + " " + score);
                        }
                    }
                }
            }
        }
    }
}