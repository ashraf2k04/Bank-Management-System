package repository;

import java.util.Collection;

import models.accounts.BankAccount;
import models.loan.Loan;
import models.transaction.Transaction;
import models.users.Customer;
import models.users.Employee;
import storage.MemoryStorage;

public class BankRepository {

    public Collection<Customer> getAllCustomers() {
        return MemoryStorage.customerMap.values();
    }

    public Collection<Employee> getAllEmployees() {
        return MemoryStorage.employeeMap.values();
    }

    public Collection<BankAccount> getAllAccounts() {
        return MemoryStorage.accountMap.values();
    }

    public Collection<Transaction> getAllTransactions() {
        return MemoryStorage.transactionList;
    }

    public Collection<Loan> getAllLoans() {
        return MemoryStorage.loanList;
    }

    public int totalCustomers() {
        return MemoryStorage.customerMap.size();
    }

    public int totalEmployees() {
        return MemoryStorage.employeeMap.size();
    }

    public int totalAccounts() {
        return MemoryStorage.accountMap.size();
    }

    public int totalTransactions() {
        return MemoryStorage.transactionList.size();
    }

    public int totalLoans() {
        return MemoryStorage.loanList.size();
    }

}