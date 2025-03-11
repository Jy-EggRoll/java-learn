package Basic;
public class ForLoopExample {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            System.out.println(i);
        }
        System.out.println("1 到 10 的整数之和：" + sum);
    }
}
