package util;

import java.text.DecimalFormat;

public final class Formatter {

    private static final DecimalFormat MONEY =
            new DecimalFormat("₹#,##0.00");

    private Formatter() {
    }

    public static String formatMoney(double amount) {

        return MONEY.format(amount);

    }

}