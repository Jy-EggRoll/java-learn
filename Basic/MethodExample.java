package Basic;
public class MethodExample {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;
        int result = add(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + result);
    }
}
