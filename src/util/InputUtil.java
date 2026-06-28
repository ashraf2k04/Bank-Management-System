package util;

import java.util.Scanner;

import exceptions.InvalidInputException;

public final class InputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtil() {
    }

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static int readInt(String message) throws InvalidInputException {

        System.out.print(message);

        try {
            return Integer.parseInt(SCANNER.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid integer.");
        }

    }

    public static double readDouble(String message) throws InvalidInputException {

        System.out.print(message);

        try {
            return Double.parseDouble(SCANNER.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid amount.");
        }

    }

    public static String readString(String message) {

        System.out.print(message);

        return SCANNER.nextLine().trim();

    }

}