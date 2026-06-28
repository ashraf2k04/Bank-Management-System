package util;

import java.util.UUID;

public final class IdGenerator {

    private IdGenerator() {
    }

    public static String generateCustomerId() {

        return "CUS" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }

    public static String generateEmployeeId() {

        return "EMP" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }

    public static String generateAccountNumber() {

        return "ACC" + System.currentTimeMillis();

    }

    public static String generateTransactionId() {

        return "TRN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }

    public static String generateLoanId() {

        return "LOAN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }

}