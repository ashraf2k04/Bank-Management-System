package repository;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidTransactionException;
import models.transaction.Transaction;
import storage.MemoryStorage;

public class TransactionRepository {

    public void addTransaction(Transaction transaction) {

        MemoryStorage.transactionList.add(transaction);

    }

    public List<Transaction> getAllTransactions() {

        return new ArrayList<>(MemoryStorage.transactionList);

    }

    public Transaction getTransaction(String transactionId)
            throws InvalidTransactionException {

        for (Transaction transaction : MemoryStorage.transactionList) {

            if (transaction.getTransactionId()
                    .equalsIgnoreCase(transactionId)) {

                return transaction;

            }

        }

        throw new InvalidTransactionException(
                "Transaction not found.");

    }

    public boolean exists(String transactionId) {

        for (Transaction transaction : MemoryStorage.transactionList) {

            if (transaction.getTransactionId()
                    .equalsIgnoreCase(transactionId)) {

                return true;

            }

        }

        return false;

    }

}