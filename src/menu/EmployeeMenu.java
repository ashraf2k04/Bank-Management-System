package menu;

import java.util.Scanner;

import exceptions.GlobalExceptionHandler;

import models.loan.Loan;
import models.loan.LoanStatus;
import models.loan.LoanType;
import models.users.Customer;
import models.users.Employee;
import models.accounts.BankAccount;

import util.IdGenerator;
import util.InputUtil;

import services.loan.LoanService;
import services.employee.EmployeeService;


public class EmployeeMenu {

    private final EmployeeService employeeService;
    private final Scanner scanner;
    private final LoanService loanService;

    public EmployeeMenu() {

        employeeService = new EmployeeService();
        scanner = InputUtil.getScanner();
        loanService = new LoanService();

    }

    public void show(Employee employee) {

        boolean logout = false;

        while (!logout) {

            try {

                System.out.println();
                System.out.println("======================================");
                System.out.println("      BANK EMPLOYEE DASHBOARD");
                System.out.println("======================================");

                System.out.println("Logged In : "
                        + employee.getFirstName()
                        + " "
                        + employee.getLastName());

                System.out.println();

                System.out.println("1. Register Customer");
                System.out.println("2. Search Customer");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Transfer Funds");
                System.out.println("6. Apply Loan");
                System.out.println("7. View Customers");
                System.out.println("8. Logout");

                System.out.print("\nChoice : ");

                int choice =
                        Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 ->
                        registerCustomer();

                    case 2 ->
                        searchCustomer();

                    case 3 ->
                        deposit();

                    case 4 ->
                        withdraw();

                    case 5 ->
                        transfer();

                    case 6 ->
                        applyLoan();

                    case 7 ->
                        viewCustomers();

                    case 8 ->
                        logout = true;

                    default ->
                        System.out.println("Invalid Choice.");

                }

            }

            catch (Exception exception) {

                GlobalExceptionHandler.handle(exception);

            }

        }

    }

    /*
     * ========================================
     * CUSTOMER
     * ========================================
     */

    private void registerCustomer() {

        try {

            System.out.println("\n========== REGISTER CUSTOMER ==========");

            String id = IdGenerator.generateCustomerId();
            System.out.println("Customer ID : " + id);

            System.out.print("First Name : ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name : ");
            String lastName = scanner.nextLine();

            System.out.print("Email : ");
            String email = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            System.out.print("Address : ");
            String address = scanner.nextLine();

            System.out.print("Date Of Birth : ");
            String dob = scanner.nextLine();

            System.out.print("SSN : ");
            String ssn = scanner.nextLine();

            System.out.print("Aadhaar Number : ");
            String aadhaar = scanner.nextLine();

            System.out.print("PAN Number : ");
            String pan = scanner.nextLine();

            System.out.print("Contact Number : ");
            String contact = scanner.nextLine();

            System.out.print("Account Type (SAVINGS/CHECKING) : ");
            String accountType = scanner.nextLine().trim().toUpperCase();

            Customer customer = new Customer(
                    id,
                    firstName,
                    lastName,
                    email,
                    password,
                    address,
                    dob,
                    ssn,
                    aadhaar,
                    pan,
                    contact
            );

            employeeService.registerCustomer(customer, accountType);

            System.out.println("\nCustomer Registered Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void searchCustomer() {

        try {

            System.out.print("Customer ID : ");

            String customerId =
                    scanner.nextLine();

            System.out.println();

            System.out.println(
                    employeeService.searchCustomer(customerId));

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ========================================
     * TELLER TRANSACTIONS
     * ========================================
     */

    private void deposit() {

        try {

            System.out.print("Account Number : ");
            String accountNumber =
                    scanner.nextLine();

            System.out.print("Amount : ");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            employeeService.tellerDeposit(
                    accountNumber,
                    amount);

            System.out.println();
            System.out.println("Deposit Successful.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void withdraw() {

        try {

            System.out.print("Account Number : ");
            String accountNumber =
                    scanner.nextLine();

            System.out.print("Amount : ");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            employeeService.tellerWithdraw(
                    accountNumber,
                    amount);

            System.out.println();
            System.out.println("Withdrawal Successful.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void transfer() {

        try {

            System.out.print("Source Account : ");
            String source =
                    scanner.nextLine();

            System.out.print("Destination Account : ");
            String destination =
                    scanner.nextLine();

            System.out.print("Amount : ");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            employeeService.fundTransfer(
                    source,
                    destination,
                    amount);

            System.out.println();
            System.out.println("Transfer Successful.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ========================================
     * LOAN
     * ========================================
     */

    private void applyLoan() {

        try {

            System.out.println();
            System.out.println("========== APPLY LOAN ==========");

            String loanId = IdGenerator.generateLoanId();
            System.out.print("Loan ID : " + loanId);
            

            System.out.print("Customer ID : ");
            String customerId = scanner.nextLine();

            Customer customer =
                    employeeService.getCustomer(customerId);

            System.out.print("Loan Type (HOME/PERSONAL/VEHICLE/EDUCATION) : ");
            LoanType loanType =
                    LoanType.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Employer : ");
            String employer = scanner.nextLine();

            System.out.print("Occupation : ");
            String occupation = scanner.nextLine();

            System.out.print("Loan Amount : ");
            double amount =
                    Double.parseDouble(scanner.nextLine());

            System.out.print("Duration (Months) : ");
            int months =
                    Integer.parseInt(scanner.nextLine());

            Loan loan = new Loan(

                    loanId,

                    customer,

                    loanType,

                    LoanStatus.PENDING,

                    employer,

                    occupation,

                    amount,

                    months

            );

            loanService.applyLoan(loan);

            System.out.println();
            System.out.println("Loan Application Submitted Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ========================================
     * VIEW CUSTOMERS
     * ========================================
     */

    private void viewCustomers() {

        try {

            System.out.println();
            System.out.println("====================================================================================================================");
            System.out.printf("%-10s %-15s %-15s %-25s %-15s %-15s %-15s %-20s %-18s %-12s%n",
                    "ID",
                    "First Name",
                    "Last Name",
                    "Email",
                    "SSN",
                    "PAN",
                    "Aadhaar",
                    "Account No",
                    "Type",
                    "Balance");
            System.out.println("====================================================================================================================");

            for (Customer customer : employeeService.getAllCustomers()) { String accountNumber = "-";
                String accountType = "-";
                double balance = 0.0;

                if (!customer.getAccounts().isEmpty()) {

                    BankAccount account = customer.getAccounts().get(0);

                    accountNumber = account.getAccountNumber();
                    accountType = account.getClass().getSimpleName();
                    balance = account.getBalance();

                }

                System.out.printf( "%-10s %-15s %-15s %-25s %-15s %-15s %-15s %-20s %-18s %-12.2f%n",

                        customer.getId(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail(),
                        customer.getSsn(),
                        customer.getPanNo(),
                        customer.getAadhaarNo(),
                        accountNumber,
                        accountType,
                        balance);

            }

            System.out.println("====================================================================================================================");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }
    }

}