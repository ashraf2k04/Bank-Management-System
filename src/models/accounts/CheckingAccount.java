package models.accounts;

import config.Constants;
import exceptions.NegativeAmountException;
import exceptions.OverdraftLimitExceededException;

public class CheckingAccount extends BankAccount {

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(String accountNumber,
                           double balance) {

        super(accountNumber, balance);

    }

    @Override
    public void withdraw(double amount)
            throws NegativeAmountException,
            OverdraftLimitExceededException {

        if (amount <= 0) {

            throw new NegativeAmountException(
                    "Withdrawal amount must be positive.");

        }

        if ((balance - amount)
                < -Constants.OVERDRAFT_LIMIT) {

            throw new OverdraftLimitExceededException(
                    "Overdraft limit exceeded.");

        }

        balance -= amount;

    }

}