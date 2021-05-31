package pl.dixu.sa.console;

import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public static void shortPrint(String text) {
        System.out.println(text);
    }

    public static void print(String text) {
        System.out.println(text + "\n");
    }

    public static void waitForEnter() {
        scanner.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
