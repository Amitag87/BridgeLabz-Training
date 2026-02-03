package json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertListToJson {

    static class Student {
        private int id;
        private String name;
        private int age;
        private double marks;

        public Student(int id, String name, int age, double marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Chaman", 22, 88.5));
        students.add(new Student(2, "Rohit", 21, 76.0));
        students.add(new Student(3, "Neha", 23, 91.2));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArray = gson.toJson(students);

        System.out.println(jsonArray);
    }
}

