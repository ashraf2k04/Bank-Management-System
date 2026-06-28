package util;

public final class ConsoleUtil {

    private ConsoleUtil() {
    }

    public static void printLine() {

        System.out.println("----------------------------------------");

    }

    public static void printHeading(String heading) {

        System.out.println();
        System.out.println("========================================");
        System.out.println(heading);
        System.out.println("========================================");

    }

    public static void pressEnter() {

        System.out.println();
        System.out.println("Press ENTER to continue...");
        InputUtil.getScanner().nextLine();

    }

}