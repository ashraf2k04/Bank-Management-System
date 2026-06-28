package util;

public final class PasswordUtil {

    private PasswordUtil() {
    }

    public static boolean isValid(String actualPassword,
                                  String enteredPassword) {

        return actualPassword.equals(enteredPassword);

    }

}