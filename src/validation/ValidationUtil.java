package validation;

import java.util.regex.Pattern;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PAN_PATTERN =
            Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");

    public static boolean isEmpty(String value) {

        return value == null || value.trim().isEmpty();

    }

    public static boolean isValidEmail(String email) {

        return EMAIL_PATTERN.matcher(email).matches();

    }

    public static boolean isValidPAN(String pan) {

        return PAN_PATTERN.matcher(pan).matches();

    }

    public static boolean isValidAadhaar(String aadhaar) {

        return aadhaar.matches("\\d{12}");

    }

    public static boolean isValidSSN(String ssn) {

        return ssn.matches("\\d{7}");

    }

    public static boolean isValidPhone(String phone) {

        return phone.matches("\\d{10}");

    }

    public static boolean isPositive(double amount) {

        return amount > 0;

    }

}