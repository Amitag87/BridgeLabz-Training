import java.util.*;

public class RankGenerator {
    public static void main(String[] args) {

        List<Student> district1 = Arrays.asList(
                new Student("Amit", 90),
                new Student("Rahul", 85)
        );

        List<Student> district2 = Arrays.asList(
                new Student("Neha", 92),
                new Student("Sneha", 85)
        );

        List<Student> allStudents = new ArrayList<>();
        allStudents.addAll(district1);
        allStudents.addAll(district2);

        List<Student> rankList = MergeSort.mergeSort(allStudents);

        rankList.forEach(System.out::println);
    }
}
