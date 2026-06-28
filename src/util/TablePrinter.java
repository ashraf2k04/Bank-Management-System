package util;

public final class TablePrinter {

    private TablePrinter() {
    }

    public static void printHeader(String... columns) {

        ConsoleUtil.printLine();

        for (String column : columns) {

            System.out.printf("%-20s", column);

        }

        System.out.println();

        ConsoleUtil.printLine();

    }

}