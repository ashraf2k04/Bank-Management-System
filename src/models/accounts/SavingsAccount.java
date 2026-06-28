package models.accounts;

import config.Constants;
import exceptions.InsufficientFundsException;
import exceptions.MinimumBalanceException;
import exceptions.NegativeAmountException;

public class SavingsAccount extends BankAccount {

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(String accountNumber,
                          double balance) {

        super(accountNumber, balance);

    }

    @Override
    public void withdraw(double amount)
            throws NegativeAmountException,
            MinimumBalanceException,
            InsufficientFundsException {

        if (amount <= 0) {

            throw new NegativeAmountException(
                    "Withdrawal amount must be positive.");

        }

        if (amount > balance) {

            throw new InsufficientFundsException(
                    "Insufficient balance.");

        }

        if ((balance - amount) < Constants.MINIMUM_BALANCE) {

            throw new MinimumBalanceException(
                    "Minimum balance of ₹"
                            + Constants.MINIMUM_BALANCE
                            + " must be maintained.");

        }

        balance -= amount;

    }

}