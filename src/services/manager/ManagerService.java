package services.manager;

import java.util.Collection;
import java.util.List;

import exceptions.CustomerNotFoundException;
import exceptions.DuplicateAadhaarException;
import exceptions.DuplicateCustomerException;
import exceptions.DuplicateAccountException;
import exceptions.DuplicateEmployeeException;
import exceptions.DuplicatePANException;
import exceptions.DuplicateSSNException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidInputException;

import models.loan.Loan;
import models.users.Customer;
import models.users.Employee;
import models.accounts.BankAccount;
import models.accounts.CheckingAccount;
import models.accounts.SavingsAccount;

import repository.BankRepository;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.AccountRepository;

import services.loan.LoanService;
import services.salary.SalaryService;

import config.Constants;

import util.IdGenerator;

public class ManagerService {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;
    private final AccountRepository accountRepository;

    private final SalaryService salaryService;
    private final LoanService loanService;
    

    public ManagerService() {

        employeeRepository = new EmployeeRepository();
        customerRepository = new CustomerRepository();
        bankRepository = new BankRepository();
        accountRepository = new AccountRepository();

        salaryService = new SalaryService();
        loanService = new LoanService();

    }

    /*
     * =========================================
     * EMPLOYEE OPERATIONS
     * =========================================
     */

    public void registerEmployee(Employee employee)
            throws DuplicateEmployeeException {

        employeeRepository.addEmployee(employee);

    }

    public Employee searchEmployee(String employeeId)
            throws EmployeeNotFoundException {

        return employeeRepository.getEmployee(employeeId);

    }

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        employeeRepository.updateEmployee(employee);

    }

    public void deleteEmployee(String employeeId)
            throws EmployeeNotFoundException {

        employeeRepository.deleteEmployee(employeeId);

    }

    public Collection<Employee> getAllEmployees() {

        return bankRepository.getAllEmployees();

    }

    public int totalEmployees() {

        return bankRepository.totalEmployees();

    }

    public boolean employeeExists(String employeeId) {

        return employeeRepository.exists(employeeId);

    }

        /*
     * =========================================
     * CUSTOMER OPERATIONS
     * =========================================
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

    public Customer searchCustomer(String customerId)
            throws CustomerNotFoundException {

        return customerRepository.getCustomer(customerId);

    }

    public void updateCustomer(Customer customer)
            throws CustomerNotFoundException {

        customerRepository.updateCustomer(customer);

    }

    public void deleteCustomer(String customerId)
            throws CustomerNotFoundException {

        customerRepository.deleteCustomer(customerId);

    }

    public Collection<Customer> getAllCustomers() {

        return bankRepository.getAllCustomers();

    }

    public int totalCustomers() {

        return bankRepository.totalCustomers();

    }

    public boolean customerExists(String customerId) {

        return customerRepository.exists(customerId);

    }

        /*
     * =========================================
     * SALARY OPERATIONS
     * =========================================
     */

    public void incrementEmployeeSalary(String employeeId,
                                        double incrementAmount)
            throws EmployeeNotFoundException {

        Employee employee =
                employeeRepository.getEmployee(employeeId);

        salaryService.incrementSalary(
                employee,
                incrementAmount);

        employeeRepository.updateEmployee(employee);

    }

    public void bulkSalaryIncrement(double incrementAmount) {

        salaryService.bulkIncrement(incrementAmount);

    }

    public void designationWiseIncrement() {

        salaryService.designationWiseIncrement();

    }

    /*
     * =========================================
     * LOAN OPERATIONS
     * =========================================
     */

    public void approveLoan(String loanId)
            throws Exception {

        loanService.approveLoan(loanId);

    }

    public void rejectLoan(String loanId)
            throws Exception {

        loanService.rejectLoan(loanId);

    }

    public void closeLoan(String loanId)
            throws Exception {

        loanService.closeLoan(loanId);

    }

    public void deleteLoan(String loanId)
            throws Exception {

        loanService.deleteLoan(loanId);

    }

    public Object searchLoan(String loanId)
            throws Exception {

        return loanService.searchLoan(loanId);

    }

    public List<Loan> getAllLoans() {

        return loanService.getAllLoans();

    }

    /*
     * =========================================
     * BANK STATISTICS
     * =========================================
     */

    public int totalAccounts() {

        return bankRepository.totalAccounts();

    }

    public int totalTransactions() {

        return bankRepository.totalTransactions();

    }

    public int totalLoans() {

        return bankRepository.totalLoans();

    }

    /*
     * =========================================
     * VIEW DATA
     * =========================================
     */

    public Collection<Employee> viewEmployees() {

        return bankRepository.getAllEmployees();

    }

    public Collection<Customer> viewCustomers() {

        return bankRepository.getAllCustomers();

    }

    /*
     * =========================================
     * MANAGER DASHBOARD
     * =========================================
     */

    public void displayStatistics() {

        System.out.println();
        System.out.println("========== BANK SUMMARY ==========");
        System.out.println("Employees    : " + totalEmployees());
        System.out.println("Customers    : " + totalCustomers());
        System.out.println("Accounts     : " + totalAccounts());
        System.out.println("Loans        : " + totalLoans());
        System.out.println("Transactions : " + totalTransactions());
        System.out.println("==================================");
        System.out.println();

    }

}