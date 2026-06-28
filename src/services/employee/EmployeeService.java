package services.employee;

import java.util.Collection;

import util.IdGenerator;

import config.Constants;

import exceptions.CustomerNotFoundException;
import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidTransactionException;
import exceptions.DuplicateAadhaarException;
import exceptions.DuplicateCustomerException;
import exceptions.DuplicatePANException;
import exceptions.DuplicateSSNException;
import exceptions.InvalidInputException;
import exceptions.DuplicateAccountException;

import models.loan.Loan;
import models.users.Customer;
import models.users.Employee;
import models.accounts.BankAccount;
import models.accounts.SavingsAccount;
import models.accounts.CheckingAccount;

import repository.BankRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.AccountRepository;

import services.loan.LoanService;
import services.transaction.TransactionService;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;
    private final AccountRepository accountRepository;

    private final TransactionService transactionService;
    private final LoanService loanService;

    public EmployeeService() {

        employeeRepository = new EmployeeRepository();
        customerRepository = new CustomerRepository();
        bankRepository = new BankRepository();
        accountRepository = new AccountRepository();

        transactionService = new TransactionService();
        loanService = new LoanService();

    }

    /*
     * ==========================================
     * REGISTER EMPLOYEE
     * ==========================================
     */

    public void registerEmployee(Employee employee)
            throws DuplicateEmployeeException {

        employeeRepository.addEmployee(employee);

    }

    /*
     * ==========================================
     * SEARCH EMPLOYEE
     * ==========================================
     */

    public Employee searchEmployee(String employeeId)
            throws EmployeeNotFoundException {

        return employeeRepository.getEmployee(employeeId);

    }

    /*
     * ==========================================
     * UPDATE EMPLOYEE
     * ==========================================
     */

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        employeeRepository.updateEmployee(employee);

    }

    /*
     * ==========================================
     * DELETE EMPLOYEE
     * ==========================================
     */

    public void deleteEmployee(String employeeId)
            throws EmployeeNotFoundException {

        employeeRepository.deleteEmployee(employeeId);

    }

    /*
     * ==========================================
     * VIEW ALL CUSTOMERS
     * ==========================================
     */

    public void registerCustomer(Customer customer, String accountType)
        throws DuplicateCustomerException,
               DuplicatePANException,
               DuplicateAadhaarException,
               DuplicateSSNException,DuplicateAccountException,
               InvalidInputException {

        customerRepository.addCustomer(customer);

        String accountNumber =
                IdGenerator.generateAccountNumber();

        BankAccount account;

        if (accountType.equalsIgnoreCase("SAVINGS")) {

            account = new SavingsAccount(

                    accountNumber,

                    1000.0

            );

        }

        else if (accountType.equalsIgnoreCase("CHECKING")) {

            account = new CheckingAccount(

                    accountNumber,

                    1000.0

            );

        }

        else {

            throw new InvalidInputException(
                    "Account Type must be SAVINGS or CHECKING.");

        }

        customer.addAccount(account);

        accountRepository.addAccount(account);

        System.out.println();
        System.out.println("=======================================");
        System.out.println("Customer Registered Successfully");
        System.out.println("---------------------------------------");
        System.out.println("Customer ID      : " + customer.getId());
        System.out.println("Customer Name    : "
                + customer.getFirstName()
                + " "
                + customer.getLastName());

        System.out.println();

        System.out.println("Account Created Successfully");

        System.out.println("Account Number   : "
                + account.getAccountNumber());

        System.out.println("Account Type     : "
                + account.getClass().getSimpleName());

        System.out.println("IFSC Code        : "
                + account.getIfscCode());

        System.out.println("Opening Balance  : ₹"
                + account.getBalance());

        System.out.println("=======================================");

    }


    public Collection<Customer> getAllCustomers() {

        return bankRepository.getAllCustomers();

    }

    public Customer getCustomer(String customerId)
        throws CustomerNotFoundException {

        return customerRepository.getCustomer(customerId);

    }

    /*
     * ==========================================
     * TELLER DEPOSIT
     * ==========================================
     */

    public void tellerDeposit(String accountNumber,
                              double amount)
            throws Exception {

        transactionService.deposit(
                accountNumber,
                amount);

    }

    /*
     * ==========================================
     * TELLER WITHDRAW
     * ==========================================
     */

    public void tellerWithdraw(String accountNumber,
                               double amount)
            throws Exception {

        transactionService.withdraw(
                accountNumber,
                amount);

    }

    /*
     * ==========================================
     * FUND TRANSFER
     * ==========================================
     */

    public void fundTransfer(String sourceAccount,
                             String destinationAccount,
                             double amount)
            throws Exception {

        transactionService.transfer(
                sourceAccount,
                destinationAccount,
                amount);

    }

    /*
     * ==========================================
     * APPLY LOAN
     * ==========================================
     */

    public void initiateLoan(Loan loan) {

        loanService.applyLoan(loan);

    }

    /*
     * ==========================================
     * SEARCH CUSTOMER
     * ==========================================
     */

    public Customer searchCustomer(String customerId)
            throws CustomerNotFoundException {

        return customerRepository.getCustomer(customerId);

    }

    /*
     * ==========================================
     * EMPLOYEE EXISTS
     * ==========================================
     */

    public boolean employeeExists(String employeeId) {

        return employeeRepository.exists(employeeId);

    }

}