package services.report;

import java.util.Collection;
import java.util.List;

import models.accounts.BankAccount;
import models.loan.Loan;
import models.transaction.Transaction;
import models.users.Customer;
import models.users.Employee;
import repository.BankRepository;

public class ReportService {

    private final BankRepository bankRepository;

    public ReportService() {

        bankRepository = new BankRepository();

    }

    /*
     * ==========================================
     * EMPLOYEE REPORT
     * ==========================================
     */

    public Collection<Employee> getEmployeeReport() {

        return bankRepository.getAllEmployees();

    }

    /*
     * ==========================================
     * CUSTOMER REPORT
     * ==========================================
     */

    public Collection<Customer> getCustomerReport() {

        return bankRepository.getAllCustomers();

    }

    /*
     * ==========================================
     * ACCOUNT REPORT
     * ==========================================
     */

    public Collection<BankAccount> getAccountReport() {

        return bankRepository.getAllAccounts();

    }

    /*
     * ==========================================
     * LOAN REPORT
     * ==========================================
     */

    public Collection<Loan> getLoanReport() {

        return bankRepository.getAllLoans();

    }

    /*
     * ==========================================
     * TRANSACTION REPORT
     * ==========================================
     */

    public Collection<Transaction> getTransactionReport() {

        return bankRepository.getAllTransactions();

    }

    /*
     * ==========================================
     * TOTALS
     * ==========================================
     */

    public int totalEmployees() {

        return bankRepository.totalEmployees();

    }

    public int totalCustomers() {

        return bankRepository.totalCustomers();

    }

    public int totalAccounts() {

        return bankRepository.totalAccounts();

    }

    public int totalLoans() {

        return bankRepository.totalLoans();

    }

    public int totalTransactions() {

        return bankRepository.totalTransactions();

    }

    /*
     * ==========================================
     * PRINT SUMMARY
     * ==========================================
     */

    public void printSummary() {

        System.out.println();
        System.out.println("========== BANK REPORT ==========");

        System.out.println("Employees      : " + totalEmployees());
        System.out.println("Customers      : " + totalCustomers());
        System.out.println("Accounts       : " + totalAccounts());
        System.out.println("Loans          : " + totalLoans());
        System.out.println("Transactions   : " + totalTransactions());

        System.out.println("=================================");
        System.out.println();

    }

}