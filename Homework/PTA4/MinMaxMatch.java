package Homework.PTA4;
import java.util.Scanner;

public class MinMaxMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String target = scanner.nextLine();
        int starIndex = pattern.indexOf("*");
        String prefix = pattern.substring(0, starIndex);
        String suffix = pattern.substring(starIndex + 1);
        int startIndex = target.indexOf(prefix);
        String targetSubString = target.substring(startIndex);
        String minMatch = findMinMatch(targetSubString, prefix, suffix);
        String maxMatch = findMaxMatch(targetSubString, prefix, suffix);
        System.out.println(minMatch);
        System.out.println(maxMatch);
        scanner.close();
    }
    
    public static String findMinMatch(String target, String prefix, String suffix) {
        int start = prefix.length();
        while (true) {
            int index = target.indexOf(suffix, start);
            if (index != -1) {
                return target.substring(0, index + suffix.length());
            }
            start++;
        }
    }

    public static String findMaxMatch(String target, String prefix, String suffix) {
        int lastIndex = target.lastIndexOf(suffix);
        return target.substring(0, lastIndex + suffix.length());
    }
}
