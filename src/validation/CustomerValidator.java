package validation;

public final class CustomerValidator {

    private CustomerValidator() {
    }

    public static boolean validateEmail(String email) {

        return ValidationUtil.isValidEmail(email);

    }

    public static boolean validatePAN(String pan) {

        return ValidationUtil.isValidPAN(pan);

    }

    public static boolean validateAadhaar(String aadhaar) {

        return ValidationUtil.isValidAadhaar(aadhaar);

    }

    public static boolean validateSSN(String ssn) {

        return ValidationUtil.isValidSSN(ssn);

    }

    public static boolean validatePhone(String phone) {

        return ValidationUtil.isValidPhone(phone);

    }

}