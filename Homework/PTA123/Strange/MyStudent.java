package Homework.PTA123.Strange;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            this.age = -1;
        }
    }
}

public class MyStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<String> invalidStudents = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            Student student = new Student(name, age);
            students.add(student);
            if (student.getAge() == -1) {
                invalidStudents.add(student.getName());
            }
        }

        int invalidCount = invalidStudents.size();

        if (invalidCount == 0) {
            System.out.println("right");
        } else if (invalidCount == 5) {
            System.out.println("all wrong");
        } else {
            System.out.println(invalidCount);
            for (String name : invalidStudents) {
                System.out.println(name);
            }
        }
        scanner.close();
    }
}
