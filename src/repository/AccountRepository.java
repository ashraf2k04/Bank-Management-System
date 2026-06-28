package repository;

import exceptions.AccountNotFoundException;
import exceptions.DuplicateAccountException;
import models.accounts.BankAccount;
import storage.MemoryStorage;

public class AccountRepository {

    public void addAccount(BankAccount account)
            throws DuplicateAccountException {

        if (MemoryStorage.accountMap.containsKey(account.getAccountNumber())) {

            throw new DuplicateAccountException(
                    "Account already exists.");

        }

        MemoryStorage.accountMap.put(
                account.getAccountNumber(),
                account);

        MemoryStorage.accountNumbers.add(
                account.getAccountNumber());

    }

    public BankAccount getAccount(String accountNumber)
            throws AccountNotFoundException {

        BankAccount account =
                MemoryStorage.accountMap.get(accountNumber);

        if (account == null) {

            throw new AccountNotFoundException(
                    "Account not found.");

        }

        return account;

    }

    public void updateAccount(BankAccount account)
            throws AccountNotFoundException {

        if (!MemoryStorage.accountMap.containsKey(account.getAccountNumber())) {

            throw new AccountNotFoundException(
                    "Account not found.");

        }

        MemoryStorage.accountMap.put(
                account.getAccountNumber(),
                account);

    }

    public void deleteAccount(String accountNumber)
            throws AccountNotFoundException {

        getAccount(accountNumber);

        MemoryStorage.accountMap.remove(accountNumber);

        MemoryStorage.accountNumbers.remove(accountNumber);

    }

    public boolean exists(String accountNumber) {

        return MemoryStorage.accountMap.containsKey(accountNumber);

    }

}