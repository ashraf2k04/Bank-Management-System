package exceptions;

public final class GlobalExceptionHandler {

    private GlobalExceptionHandler() {
    }

    public static void handle(Exception exception) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("ERROR : " + exception.getMessage());
        System.out.println("========================================");
        System.out.println();

    }

}