package config;

public final class Constants {

    private Constants() {
    }

    // Bank Details

    public static final String BANK_NAME = "BMS National Bank";

    public static final String IFSC_CODE = "BMS0001234";
    public static final String DEFAULT_IFSC = "BMS0001234";

    public static final String CURRENCY = "₹";

    // Savings Account

    public static final double MINIMUM_BALANCE = 1000.00;

    // Checking Account

    public static final double OVERDRAFT_LIMIT = 5000.00;

    // Current Account

    public static final double CURRENT_ACCOUNT_TRANSACTION_CHARGE = 5.00;

    // Initial Password

    public static final String DEFAULT_PASSWORD = "12345";

}