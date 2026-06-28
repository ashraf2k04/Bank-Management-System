package services.transaction;

import java.util.List;

import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;
import exceptions.InvalidTransactionException;
import exceptions.MinimumBalanceException;
import exceptions.NegativeAmountException;
import exceptions.OverdraftLimitExceededException;
import models.accounts.BankAccount;
import models.transaction.Transaction;
import models.transaction.TransactionStatus;
import models.transaction.TransactionType;
import repository.AccountRepository;
import repository.TransactionRepository;
import util.IdGenerator;

public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService() {

        accountRepository = new AccountRepository();
        transactionRepository = new TransactionRepository();

    }

    /*
     * ========================================
     * DEPOSIT
     * ========================================
     */

    public void deposit(String accountNumber,
                        double amount)
            throws AccountNotFoundException,
            NegativeAmountException {

        BankAccount account =
                accountRepository.getAccount(accountNumber);

        account.deposit(amount);

        accountRepository.updateAccount(account);

        Transaction transaction =
                new Transaction(
                        IdGenerator.generateTransactionId(),
                        "BANK",
                        accountNumber,
                        amount,
                        TransactionType.DEPOSIT,
                        TransactionStatus.SUCCESS);

        account.addTransaction(transaction);

        transactionRepository.addTransaction(transaction);

    }

    /*
     * ========================================
     * WITHDRAW
     * ========================================
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

        Transaction transaction =
                new Transaction(
                        IdGenerator.generateTransactionId(),
                        accountNumber,
                        "BANK",
                        amount,
                        TransactionType.WITHDRAW,
                        TransactionStatus.SUCCESS);

        account.addTransaction(transaction);

        transactionRepository.addTransaction(transaction);

    }

    /*
     * ========================================
     * FUND TRANSFER
     * ========================================
     */

    public void transfer(String sourceAccount,
                         String destinationAccount,
                         double amount)
            throws AccountNotFoundException,
            NegativeAmountException,
            InsufficientFundsException,
            MinimumBalanceException,
            OverdraftLimitExceededException {

        BankAccount sender =
                accountRepository.getAccount(sourceAccount);

        BankAccount receiver =
                accountRepository.getAccount(destinationAccount);

        sender.withdraw(amount);

        receiver.deposit(amount);

        accountRepository.updateAccount(sender);
        accountRepository.updateAccount(receiver);

        Transaction transaction =
                new Transaction(
                        IdGenerator.generateTransactionId(),
                        sourceAccount,
                        destinationAccount,
                        amount,
                        TransactionType.TRANSFER,
                        TransactionStatus.SUCCESS);

        sender.addTransaction(transaction);

        receiver.addTransaction(transaction);

        transactionRepository.addTransaction(transaction);

    }

    /*
     * ========================================
     * SEARCH TRANSACTION
     * ========================================
     */

    public Transaction searchTransaction(String transactionId)
            throws InvalidTransactionException {

        return transactionRepository.getTransaction(transactionId);

    }

    /*
     * ========================================
     * ALL TRANSACTIONS
     * ========================================
     */

    public List<Transaction> getAllTransactions() {

        return transactionRepository.getAllTransactions();

    }

    /*
     * ========================================
     * ACCOUNT HISTORY
     * ========================================
     */

    public List<Transaction> getTransactionHistory(
            String accountNumber)
            throws AccountNotFoundException {

        BankAccount account =
                accountRepository.getAccount(accountNumber);

        return account.getTransactionHistory();

    }

}