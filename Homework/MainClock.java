package Homework;
import java.util.Scanner;

class Clock {
    private int hour;
    private int minute;
    private int second;

    public Clock(int totalSeconds) {
        this.hour = totalSeconds / (60 * 60);
        totalSeconds %= 60 * 60;
        this.minute = totalSeconds / 60;
        totalSeconds %= 60;
        this.second = totalSeconds;
    }

    public void printTime() {
        System.out.println(hour + ":" + minute + ":" + second);
    }
}

public class MainClock {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number_of_line = scn.nextInt();
        for (int i = 0; i < number_of_line; i++) {
            int total_seconds = scn.nextInt();
            Clock clock = new Clock(total_seconds);
            clock.printTime();
        }
        scn.close();
    }
}