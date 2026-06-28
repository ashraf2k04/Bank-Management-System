package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import models.accounts.BankAccount;
import models.loan.Loan;
import models.transaction.Transaction;
import models.users.Customer;
import models.users.Employee;

public final class MemoryStorage {

    /*---------------------------------------------------------
     * CUSTOMER STORAGE
     ---------------------------------------------------------*/
    public static final HashMap<String, Customer> customerMap = new HashMap<>();

    /*---------------------------------------------------------
     * EMPLOYEE STORAGE
     ---------------------------------------------------------*/
    public static final HashMap<String, Employee> employeeMap = new HashMap<>();

    /*---------------------------------------------------------
     * ACCOUNT STORAGE
     ---------------------------------------------------------*/
    public static final HashMap<String, BankAccount> accountMap = new HashMap<>();

    /*---------------------------------------------------------
     * TRANSACTION STORAGE
     ---------------------------------------------------------*/
    public static final ArrayList<Transaction> transactionList = new ArrayList<>();

    /*---------------------------------------------------------
     * LOAN STORAGE
     ---------------------------------------------------------*/
    public static final ArrayList<Loan> loanList = new ArrayList<>();

    /*---------------------------------------------------------
     * DUPLICATE VALIDATION
     ---------------------------------------------------------*/
    public static final HashSet<String> accountNumbers = new HashSet<>();

    public static final HashSet<String> employeeIds = new HashSet<>();

    public static final HashSet<String> customerIds = new HashSet<>();

    public static final HashSet<String> aadhaarNumbers = new HashSet<>();

    public static final HashSet<String> panNumbers = new HashSet<>();

    public static final HashSet<String> ssnNumbers = new HashSet<>();

    public static final HashSet<String> emails = new HashSet<>();

    private MemoryStorage() {
    }

    /**
     * Clears all runtime data.
     */
    public static void clearAll() {

        customerMap.clear();
        employeeMap.clear();
        accountMap.clear();

        transactionList.clear();
        loanList.clear();

        accountNumbers.clear();
        employeeIds.clear();
        customerIds.clear();

        aadhaarNumbers.clear();
        panNumbers.clear();
        ssnNumbers.clear();
        emails.clear();

    }

}