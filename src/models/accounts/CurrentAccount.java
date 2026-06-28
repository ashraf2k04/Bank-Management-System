package models.accounts;

import config.Constants;
import exceptions.InsufficientFundsException;
import exceptions.NegativeAmountException;

public class CurrentAccount extends BankAccount {

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String accountNumber,
                          double balance) {

        super(accountNumber, balance);

    }

    @Override
    public void withdraw(double amount)
            throws NegativeAmountException,
            InsufficientFundsException {

        if (amount <= 0) {

            throw new NegativeAmountException(
                    "Withdrawal amount must be positive.");

        }

        double totalAmount =
                amount +
                        Constants.CURRENT_ACCOUNT_TRANSACTION_CHARGE;

        if (totalAmount > balance) {

            throw new InsufficientFundsException(
                    "Insufficient balance.");

        }

        balance -= totalAmount;

    }

}