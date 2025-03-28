package Homework.PTA4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class CommandMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            commands.add(scanner.nextLine());
        }
        String testString = scanner.nextLine();
        ArrayList<String> matchedCommands = new ArrayList<>();
        for (String command : commands) {
            if (command.startsWith(testString)) {
                matchedCommands.add(command);
            }
        }
        Collections.sort(matchedCommands);
        for (String matchedCommand : matchedCommands) {
            System.out.println(matchedCommand);
        }
        scanner.close();
    }
}
