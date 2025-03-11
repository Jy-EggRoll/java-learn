package Basic;
import java.util.Scanner;

public class IfElseExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的年龄：");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("你可以投票。");
        } else {
            System.out.println("你还不能投票。");
        }
        scanner.close();
    }
}
