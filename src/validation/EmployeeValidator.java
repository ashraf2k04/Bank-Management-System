package validation;

public final class EmployeeValidator {

    private EmployeeValidator() {
    }

    public static boolean validateEmail(String email) {

        return ValidationUtil.isValidEmail(email);

    }

    public static boolean validateSalary(double salary) {

        return ValidationUtil.isPositive(salary);

    }

}