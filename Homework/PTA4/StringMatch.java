package Homework.PTA4;
import java.util.Scanner;

public class StringMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String pattern = input[0];
            String target = input[1];
            boolean isMatch = match(pattern, target);
            if (isMatch) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        scanner.close();
    }

    public static boolean match(String pattern, String target) {
        if (pattern.contains("_")) {
            int index = pattern.indexOf("_");
            if (pattern.length() != target.length()) {
                return false;
            }
            for (int i = 0; i < pattern.length(); i++) {
                if (i != index && pattern.charAt(i) != target.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else if (pattern.contains("%")) {
            int index = pattern.indexOf("%");
            String perfix = pattern.substring(0, index);
            String suffix = pattern.substring(index + 1);
            return target.startsWith(perfix) && target.endsWith(suffix);
        }
        return false;
    }
}