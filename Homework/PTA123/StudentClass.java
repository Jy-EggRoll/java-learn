package Homework.PTA123;
import java.util.Scanner;

class Student {
    private String studentNumber;
    private String studentName;
    private int markForMaths;
    private int markForEnglish;
    private int markForScience;

    public Student() {
        this.studentNumber = "";
        this.studentName = "";
        this.markForMaths = -1;
        this.markForEnglish = -1;
        this.markForScience = -1;
    }

    public Student(String number, String name) {
        this.studentNumber = number;
        this.studentName = name;
        this.markForMaths = -1;
        this.markForEnglish = -1;
        this.markForScience = -1;
    }

    public String getNumber() {
        return studentNumber;
    }

    public String getName() {
        return studentName;
    }

    public void enterMarks(int markForMaths, int markForEnglish, int markForScience) {
        this.markForMaths = markForMaths;
        this.markForEnglish = markForEnglish;
        this.markForScience = markForScience;
    }

    public int getMathsMark() {
        return markForMaths;
    }

    public int getEnglishMark() {
        return markForEnglish;
    }

    public int getScienceMark() {
        return markForScience;
    }

    public double calculateAverage() {
        if (markForEnglish == -1 || markForMaths == -1 || markForScience == -1) {
            return -1;
        }
        return (markForEnglish + markForMaths + markForScience) / 3.0;
    }

    @Override
    public String toString() {
        double average = calculateAverage();
        if (average == -1) {
            return "No marks!";
        }
        return "Student ID:" + studentNumber + "\n" +
                "Name:" + studentName + "\n" +
                "Math:" + markForMaths + "\n" +
                "English:" + markForEnglish + "\n" +
                "Science:" + markForScience + "\n" +
                "Average Score:" + String.format("%.1f", average);
    }
}

public class StudentClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        String name = scanner.next();
        int maths = scanner.nextInt();
        int english = scanner.nextInt();
        int science = scanner.nextInt();

        Student student = new Student(number, name);
        student.enterMarks(maths, english, science);
        System.out.println(student);

        scanner.close();
    }
}
