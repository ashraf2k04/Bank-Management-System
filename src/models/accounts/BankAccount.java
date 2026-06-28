package models.accounts;

import config.Constants;
import exceptions.InsufficientFundsException;
import exceptions.NegativeAmountException;
import exceptions.MinimumBalanceException;
import exceptions.OverdraftLimitExceededException;

import java.util.ArrayList;
import java.util.List;

import models.transaction.Transaction;


public abstract class BankAccount {

    private String accountNumber;
    private String ifscCode;
    protected double balance;

    private List<Transaction> transactionHistory =
        new ArrayList<>();

    public BankAccount() {
        this.ifscCode = Constants.IFSC_CODE;
    }

    public BankAccount(String accountNumber, double balance) {

        this.accountNumber = accountNumber;
        this.ifscCode = Constants.IFSC_CODE;
        this.balance = balance;

    }

    public void deposit(double amount)
            throws NegativeAmountException {

        if (amount <= 0) {
            throw new NegativeAmountException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;

    }

    // public abstract void withdraw(double amount)
    //         throws NegativeAmountException,
    //         InsufficientFundsException;
    public abstract void withdraw(double amount)
        throws NegativeAmountException,
               InsufficientFundsException,
               MinimumBalanceException,
               OverdraftLimitExceededException;

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    @Override
    public String toString() {

        return "Account Number : " + accountNumber +
                "\nIFSC          : " + ifscCode +
                "\nBalance       : ₹" + balance;

    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

}