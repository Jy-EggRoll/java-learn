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
                "Average Score:" + String.format("%.1f", average);
    }
}

class StudentList {
    private Student[] list;
    private int total;

    public StudentList(int length) {
        list = new Student[length];
        total = 0;
    }

    public boolean add(Student stu) {
        for (int i = 0; i < total; i++) {
            if (list[i].getNumber().equals(stu.getNumber())) {
                return false;
            }
        }
        if (total < list.length) {
            list[total++] = stu;
            return true;
        }
        return false;
    }

    public boolean remove(String number) {
        for (int i = 0; i < total; i++) {
            if (list[i].getNumber().equals(number)) {
                for (int j = i; j < total - 1; j++) {
                    list[j] = list[j + 1];
                }
                total--;
                return true;
            }
        }
        return false;
    }

    public boolean updateItem(String number, int math, int english, int science) {
        for (int i = 0; i < total; i++) {
            if (list[i].getNumber().equals(number)) {
                list[i].enterMarks(math, english, science);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public int getTotal() {
        return total;
    }

    public Student getItem(String number) {
        for (int i = 0; i < total; i++) {
            if (list[i].getNumber().equals(number)) {
                return list[i];
            }
        }
        return null;
    }
}

public class MyStudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StudentList studentList = new StudentList(130);

        for (int i = 0; i < n; i++) {
            int function = scanner.nextInt();
            switch (function) {
                case 1:
                    String number = scanner.next();
                    String name = scanner.next();
                    int math = scanner.nextInt();
                    int english = scanner.nextInt();
                    int science = scanner.nextInt();
                    Student student = new Student(number, name);
                    student.enterMarks(math, english, science);
                    if (studentList.add(student)) {
                        System.out.println("Add success");
                    } else {
                        System.out.println("Students already exist");
                    }
                    break;
                case 2:
                    String deleteNumber = scanner.next();
                    if (studentList.remove(deleteNumber)) {
                        System.out.println("Delete success");
                    } else {
                        System.out.println("Students do not exist");
                    }
                    break;
                case 3:
                    String updateNumber = scanner.next();
                    int updateMath = scanner.nextInt();
                    int updateEnglish = scanner.nextInt();
                    int updateScience = scanner.nextInt();
                    if (studentList.updateItem(updateNumber, updateMath, updateEnglish, updateScience)) {
                        System.out.println("Update success");
                    } else {
                        System.out.println("Students do not exist");
                    }
                    break;
                case 4:
                    String getNumber = scanner.next();
                    Student getStudent = studentList.getItem(getNumber);
                    if (getStudent != null) {
                        System.out.println(getStudent);
                    } else {
                        System.out.println("Students do not exist");
                    }
                    break;
                case 5:
                    if (studentList.isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("List is not empty");
                    }
                    break;
                case 6:
                    System.out.println(studentList.getTotal());
                    break;
            }
        }
        scanner.close();
    }
}
