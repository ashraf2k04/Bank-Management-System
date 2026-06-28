package services.account;

import config.Constants;
import exceptions.AccountNotFoundException;
import exceptions.DuplicateAccountException;
import exceptions.InsufficientFundsException;
import exceptions.MinimumBalanceException;
import exceptions.NegativeAmountException;
import exceptions.OverdraftLimitExceededException;
import models.accounts.BankAccount;
import models.accounts.CheckingAccount;
import models.accounts.CurrentAccount;
import models.accounts.SavingsAccount;
import repository.AccountRepository;
import util.IdGenerator;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService() {

        accountRepository = new AccountRepository();

    }

    /*
     * ======================================
     * CREATE SAVINGS ACCOUNT
     * ======================================
     */

    public SavingsAccount createSavingsAccount(double initialDeposit)
            throws DuplicateAccountException,
            NegativeAmountException {

        if (initialDeposit < Constants.MINIMUM_BALANCE) {

            throw new NegativeAmountException(
                    "Minimum opening balance for Savings Account is ₹"
                            + Constants.MINIMUM_BALANCE);

        }

        SavingsAccount account =
                new SavingsAccount(
                        IdGenerator.generateAccountNumber(),
                        0);

        account.deposit(initialDeposit);

        accountRepository.addAccount(account);

        return account;

    }

    /*
     * ======================================
     * CREATE CHECKING ACCOUNT
     * ======================================
     */

    public CheckingAccount createCheckingAccount(double initialDeposit)
            throws DuplicateAccountException,
            NegativeAmountException {

        CheckingAccount account =
                new CheckingAccount(
                        IdGenerator.generateAccountNumber(),
                        0);

        account.deposit(initialDeposit);

        accountRepository.addAccount(account);

        return account;

    }

    /*
     * ======================================
     * CREATE CURRENT ACCOUNT
     * ======================================
     */

    public CurrentAccount createCurrentAccount(double initialDeposit)
            throws DuplicateAccountException,
            NegativeAmountException {

        CurrentAccount account =
                new CurrentAccount(
                        IdGenerator.generateAccountNumber(),
                        0);

        account.deposit(initialDeposit);

        accountRepository.addAccount(account);

        return account;

    }

    /*
     * ======================================
     * DEPOSIT
     * ======================================
     */

    public void deposit(String accountNumber,
                        double amount)
            throws AccountNotFoundException,
            NegativeAmountException {

        BankAccount account =
                accountRepository.getAccount(accountNumber);

        account.deposit(amount);

        accountRepository.updateAccount(account);

    }

    /*
     * ======================================
     * WITHDRAW
     * ======================================
     */

    public void withdraw(String accountNumber,
                         double amount)
            throws AccountNotFoundException,
            NegativeAmountException,
            InsufficientFundsException,
            MinimumBalanceException,
            OverdraftLimitExceededException {

        BankAccount account =
                accountRepository.getAccount(accountNumber);

        account.withdraw(amount);

        accountRepository.updateAccount(account);

    }

    /*
     * ======================================
     * BALANCE
     * ======================================
     */

    public double getBalance(String accountNumber)
            throws AccountNotFoundException {

        return accountRepository
                .getAccount(accountNumber)
                .getBalance();

    }

    /*
     * ======================================
     * SEARCH ACCOUNT
     * ======================================
     */

    public BankAccount searchAccount(String accountNumber)
            throws AccountNotFoundException {

        return accountRepository.getAccount(accountNumber);

    }

    /*
     * ======================================
     * DELETE ACCOUNT
     * ======================================
     */

    public void deleteAccount(String accountNumber)
            throws AccountNotFoundException {

        accountRepository.deleteAccount(accountNumber);

    }

    /*
     * ======================================
     * EXISTS
     * ======================================
     */

    public boolean accountExists(String accountNumber) {

        return accountRepository.exists(accountNumber);

    }

}