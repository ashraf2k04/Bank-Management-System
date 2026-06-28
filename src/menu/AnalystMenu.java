package menu;

import java.util.Scanner;

import exceptions.GlobalExceptionHandler;

import services.report.ReportService;

import util.InputUtil;

import models.users.Employee;
import models.users.Customer;
import models.accounts.BankAccount;

public class AnalystMenu {

    private final ReportService reportService;
    private final Scanner scanner;

    public AnalystMenu() {

        reportService = new ReportService();
        scanner = InputUtil.getScanner();

    }

    public void show(Employee analyst) {

        boolean logout = false;

        while (!logout) {

            try {

                System.out.println();
                System.out.println("======================================");
                System.out.println("      FINANCIAL ANALYST DASHBOARD");
                System.out.println("======================================");

                System.out.println("Welcome : "
                        + analyst.getFirstName()
                        + " "
                        + analyst.getLastName());

                System.out.println();

                System.out.println("1. Employee Report");
                System.out.println("2. Customer Report");
                System.out.println("3. Account Report");
                System.out.println("4. Loan Report");
                System.out.println("5. Transaction Report");
                System.out.println("6. Summary Report");
                System.out.println("7. Logout");

                System.out.print("\nChoice : ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 -> employeeReport();

                    case 2 -> customerReport();

                    case 3 -> accountReport();

                    case 4 -> loanReport();

                    case 5 -> transactionReport();

                    case 6 ->
                            reportService.printSummary();

                    case 7 ->
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

    public void employeeReport() {
        System.out.println();
        System.out.println("==============================================================================================================================================================================");
        System.out.printf(
                "%-10s %-20s %-28s %-12s %-18s %-20s %-18s %-22s %-12s%n",
                "Emp ID",
                "Name",
                "Email",
                "DOB",
                "Department",
                "Designation",
                "Role",
                "Address",
                "Salary");
        System.out.println("==============================================================================================================================================================================");

        for (Employee employee : reportService.getEmployeeReport()) {

            System.out.printf(
                    "%-10s %-20s %-28s %-12s %-18s %-20s %-18s %-22s Rs. %-10.2f%n",

                    employee.getEmployeeId(),

                    employee.getFirstName() + " " + employee.getLastName(),

                    employee.getEmail(),

                    employee.getDob(),

                    employee.getDepartment(),

                    employee.getDesignation(),

                    employee.getRole(),

                    employee.getAddress(),

                    employee.getSalary());

        }

        System.out.println("==============================================================================================================================================================================");
    }

    public void customerReport(){

            var customers = reportService.getCustomerReport();

            if (customers.isEmpty()) {

                System.out.println();
                System.out.println("===============================================================");
                System.out.println("                 NO CUSTOMERS FOUND");
                System.out.println("===============================================================");
            }
            else {
                System.out.println();
                System.out.println("==============================================================================================================================================================================================");
                System.out.printf(
                        "%-10s %-20s %-28s %-15s %-15s %-15s %-15s %-15s %-22s %-18s %-12s%n",

                        "Cust ID",
                        "Name",
                        "Email",
                        "SSN",
                        "PAN",
                        "Aadhaar",
                        "Contact",
                        "DOB",
                        "Account No",
                        "Account Type",
                        "Balance");

                System.out.println("==============================================================================================================================================================================================");

                for (Customer customer : customers) {

                    String accountNumber = "-";
                    String accountType = "-";
                    double balance = 0.0;

                    if (!customer.getAccounts().isEmpty()) {

                        BankAccount account = customer.getAccounts().get(0);

                        accountNumber = account.getAccountNumber();
                        accountType = account.getClass().getSimpleName();
                        balance = account.getBalance();

                    }

                    System.out.printf(
                            "%-10s %-20s %-28s %-15s %-15s %-15s %-15s %-15s %-22s %-18s Rs. %-10.2f%n",

                            customer.getId(),

                            customer.getFirstName() + " " + customer.getLastName(),

                            customer.getEmail(),

                            customer.getSsn(),

                            customer.getPanNo(),

                            customer.getAadhaarNo(),

                            customer.getContactNumber(),

                            customer.getDob(),

                            accountNumber,

                            accountType,

                            balance);

                }

                System.out.println("==============================================================================================================================================================================================");
            }
    }

    public void accountReport(){
        var accounts = reportService.getAccountReport();

        if (accounts.isEmpty()) {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("        NO BANK ACCOUNTS FOUND");
            System.out.println("==============================================");
        }
        else {
            System.out.println();
            System.out.println("====================================================================================");
            System.out.printf("%-22s %-15s %-15s%n",
                    "Account Number",
                    "IFSC Code",
                    "Balance");
            System.out.println("====================================================================================");

            for (var account : accounts) {

                System.out.printf("%-22s %-15s Rs. %-12.2f%n",

                        account.getAccountNumber(),
                        account.getIfscCode(),
                        account.getBalance());

            }

            System.out.println("====================================================================================");
        }
    }

    public void loanReport() {
        var loans = reportService.getLoanReport();

        if (loans.isEmpty()) {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("      NO LOAN APPLICATIONS FOUND");
            System.out.println("==============================================");

        }
        else {
            System.out.println();
            System.out.println("==================================================================================================================================================================================");
            System.out.printf("%-12s %-20s %-15s %-12s %-15s %-18s %-12s %-12s%n",

                    "Loan ID",
                    "Customer",
                    "Type",
                    "Status",
                    "Employer",
                    "Occupation",
                    "Amount",
                    "Duration");

            System.out.println("==================================================================================================================================================================================");

            for (var loan : loans) {

                System.out.printf("%-12s %-20s %-15s %-12s %-15s %-18s Rs. %-10.2f %-12d%n",

                        loan.getLoanId(),

                        loan.getCustomer().getFirstName()
                                + " "
                                + loan.getCustomer().getLastName(),

                        loan.getLoanType(),

                        loan.getLoanStatus(),

                        loan.getEmployer(),

                        loan.getOccupation(),

                        loan.getLoanAmount(),

                        loan.getDurationMonths());

            }

            System.out.println("==================================================================================================================================================================================");
        }
    }

    public void transactionReport(){
        var transactions = reportService.getTransactionReport();

        if (transactions.isEmpty()) {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("       NO TRANSACTIONS AVAILABLE");
            System.out.println("==============================================");
        }
        else {
            System.out.println();
            System.out.println("========================================================================================================================================================================");
            System.out.printf("%-12s %-20s %-20s %-15s %-15s %-25s %-18s%n",

                    "Txn ID",
                    "Source Account",
                    "Destination",
                    "Type",
                    "Amount",
                    "Date & Time",
                    "tansaction Status");

            System.out.println("========================================================================================================================================================================");

            for (var transaction : transactions) {

                System.out.printf("%-12s %-20s %-20s %-15s Rs. %-11.2f %-25s %-18s%n",

                        transaction.getTransactionId(),

                        transaction.getSourceAccountNumber(),

                        transaction.getDestinationAccountNumber(),

                        transaction.getTransactionType(),

                        transaction.getAmount(),

                        transaction.getTransactionDateTime(),

                        transaction.getTransactionStatus());

            }

            System.out.println("========================================================================================================================================================================");
        }
    }
}