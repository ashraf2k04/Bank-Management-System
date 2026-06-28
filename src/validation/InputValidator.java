package validation;

import exceptions.InvalidInputException;

public final class InputValidator {

    private InputValidator() {
    }

    public static void validateMenuChoice(int choice,
                                          int min,
                                          int max)
            throws InvalidInputException {

        if (choice < min || choice > max) {

            throw new InvalidInputException(
                    "Please choose a valid menu option.");

        }

    }

    public static void validateNotEmpty(String value,
                                        String fieldName)
            throws InvalidInputException {

        if (ValidationUtil.isEmpty(value)) {

            throw new InvalidInputException(
                    fieldName + " cannot be empty.");

        }

    }

}