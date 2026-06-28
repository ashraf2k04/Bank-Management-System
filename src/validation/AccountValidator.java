package validation;

public final class AccountValidator {

    private AccountValidator() {
    }

    public static boolean validateAmount(double amount) {

        return ValidationUtil.isPositive(amount);

    }

}