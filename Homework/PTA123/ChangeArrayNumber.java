package Homework.PTA123;
import java.util.Scanner;

public class ChangeArrayNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[n];
    

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int temp = a[i];
            a[i] = a[b[i]];
            a[b[i]] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + " ");
            }
        }
        scanner.close();
    }
}
