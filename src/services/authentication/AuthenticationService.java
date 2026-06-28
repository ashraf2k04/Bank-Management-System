package services.authentication;

import config.Constants;

import enums.Department;
import enums.Designation;
import enums.Role;

import exceptions.CustomerNotFoundException;
import exceptions.EmployeeNotFoundException;
import exceptions.InvalidLoginException;

import models.users.Customer;
import models.users.Employee;
import models.accounts.BankAccount;
import models.accounts.SavingsAccount;
import models.loan.Loan;
import models.loan.LoanType;
import models.loan.LoanStatus;

import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.AccountRepository;
import repository.LoanRepository;


import util.IdGenerator;

public class AuthenticationService {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final AccountRepository accountRepository;
    private final LoanRepository loanRepository;

    public AuthenticationService() {

        customerRepository = new CustomerRepository();
        employeeRepository = new EmployeeRepository();
        accountRepository = new AccountRepository();
        loanRepository = new LoanRepository();

    }

    /*
     * ===============================
     * Employee Login
     * ===============================
     */

    public Employee employeeLogin(String employeeId,
                                  String password)
            throws EmployeeNotFoundException,
            InvalidLoginException {

        Employee employee =
                employeeRepository.getEmployee(employeeId);

        if (!employee.validateLogin(password)) {

            throw new InvalidLoginException(
                    "Invalid Password.");

        }

        return employee;

    }

    /*
     * ===============================
     * Customer Login
     * ===============================
     */

    public Customer customerLogin(String customerId,
                                  String password)
            throws CustomerNotFoundException,
            InvalidLoginException {

        Customer customer =
                customerRepository.getCustomer(customerId);

        if (!customer.validateLogin(password)) {

            throw new InvalidLoginException(
                    "Invalid Password.");

        }

        return customer;

    }

    /*
     * ===============================
     * Role Validation
     * ===============================
     */

    public boolean isManager(Employee employee) {

        return employee.getRole() == Role.BANK_MANAGER;

    }

    public boolean isEmployee(Employee employee) {

        return employee.getRole() == Role.BANK_EMPLOYEE;

    }

    public boolean isAnalyst(Employee employee) {

        return employee.getRole() == Role.FINANCIAL_ANALYST;

    }



    /*
    * ======================================
    * INITIALIZE DEFAULT USERS
    * ======================================
    */

   public void initializeDefaultUsers() {

        try {

            if (!employeeRepository.exists("EMP1001")) {
                employeeRepository.addEmployee(createDefaultManager());
            }

            if (!employeeRepository.exists("EMP1002")) {
                employeeRepository.addEmployee(createDefaultEmployee());
            }

            if (!employeeRepository.exists("EMP1003")) {
                employeeRepository.addEmployee(createDefaultAnalyst());
            }

            if (!customerRepository.exists("CUS1001")) {
                customerRepository.addCustomer(createDefaultCustomer());
            }

            if (!customerRepository.exists("CUS1002")) {
                customerRepository.addCustomer(createSecondCustomer());
            }

        } catch (Exception ignored) {

        }

    }

    /*
     * ===============================
     * Default Users
     * ===============================
     */



    public Employee createDefaultManager() {

        return new Employee(
                "EMP1001",
                "System",
                "Administrator",
                "admin@bank.com",
                Constants.DEFAULT_PASSWORD,
                "Head Office",
                "01-01-1990",
                "EMP1001",
                Designation.MANAGER,
                Department.ADMINISTRATION,
                Role.BANK_MANAGER,
                100000
        );

    }

    public Employee createDefaultEmployee() {

        return new Employee(
                "EMP1002",
                "Rahul",
                "Sharma",
                "employee@bank.com",
                Constants.DEFAULT_PASSWORD,
                "Delhi",
                "10-04-1998",
                "EMP1002",
                Designation.CLERK,
                Department.CUSTOMER_SERVICE,
                Role.BANK_EMPLOYEE,
                30000
        );

    }

        public Employee createDefaultAnalyst() {

        return new Employee(
                "EMP1003",
                "Amit",
                "Kumar",
                "analyst@bank.com",
                Constants.DEFAULT_PASSWORD,
                "Mumbai",
                "20-08-1996",
                "EMP1003",
                Designation.ACCOUNTANT,
                Department.FINANCE,
                Role.FINANCIAL_ANALYST,
                65000
        );

    }

    public Customer createDefaultCustomer() {

        Customer customer = new Customer(
                "CUS1001",
                "Ashraf",
                "Ali",
                "customer@bank.com",
                Constants.DEFAULT_PASSWORD,
                "Patna",
                "15-05-2000",
                "1234567",
                "123456789012",
                "ABCDE1234F",
                "9876543210"
        );

        BankAccount account = new SavingsAccount(
                IdGenerator.generateAccountNumber(),
                1000.0
        );

        customer.addAccount(account);

        try {

            accountRepository.addAccount(account);

            Loan loan = new Loan(
                    "LOAN1001",
                    customer,
                    LoanType.PERSONAL,
                    LoanStatus.PENDING,
                    "TCS",
                    "Software Engineer",
                    250000,
                    36
            );

            loanRepository.addLoan(loan);

        } catch (Exception ignored) {

        }


        return customer;

    }

    public Customer createSecondCustomer() {

        Customer customer = new Customer(
                "CUS1002",
                "Riya",
                "Sharma",
                "riya@bank.com",
                Constants.DEFAULT_PASSWORD,
                "Mumbai",
                "20-07-2001",
                "7654321",
                "987654321012",
                "XYZAB1234P",
                "9876501234"
        );

        BankAccount account = new SavingsAccount(
                IdGenerator.generateAccountNumber(),
                5000.0
        );

        customer.addAccount(account);

        try {

            accountRepository.addAccount(account);

        } catch (Exception ignored) {

        }

        return customer;

    }

}