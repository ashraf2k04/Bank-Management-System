package menu;

import java.util.Scanner;

import exceptions.GlobalExceptionHandler;
import models.accounts.BankAccount;
import models.transaction.Transaction;
import models.users.Customer;
import services.customer.CustomerService;
import services.transaction.TransactionService;
import util.InputUtil;

public class CustomerMenu {

    private final CustomerService customerService;
    private final TransactionService transactionService;

    private final Scanner scanner;

    public CustomerMenu() {

        customerService = new CustomerService();
        transactionService = new TransactionService();

        scanner = InputUtil.getScanner();

    }

    public void show(Customer customer) {

        boolean logout = false;

        while (!logout) {

            try {

                System.out.println();
                System.out.println("======================================");
                System.out.println("        CUSTOMER DASHBOARD");
                System.out.println("======================================");

                System.out.println("Welcome : "
                        + customer.getFirstName()
                        + " "
                        + customer.getLastName());

                System.out.println();

                System.out.println("1. View My Accounts");
                System.out.println("2. Balance Inquiry");
                System.out.println("3. Transfer Funds");
                System.out.println("4. Transaction History");
                System.out.println("5. Update Contact Number");
                System.out.println("6. Update Email");
                System.out.println("7. Logout");

                System.out.print("\nChoice : ");

                int choice =
                        Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 ->
                        viewAccounts(customer);

                    case 2 ->
                        balanceInquiry(customer);

                    case 3 ->
                        transfer(customer);

                    case 4 ->
                        transactionHistory(customer);

                    case 5 ->
                        updateContact(customer);

                    case 6 ->
                        updateEmail(customer);

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

    /*
     * ==========================================
     * VIEW ACCOUNTS
     * ==========================================
     */

    private void viewAccounts(Customer customer) {

        System.out.println();

        for (BankAccount account :
                customer.getAccounts()) {

            System.out.println(account);
            System.out.println();

        }

    }

    /*
     * ==========================================
     * BALANCE
     * ==========================================
     */

    private boolean validateCustomerAccount(Customer customer,
                                            String accountNumber) {

        for (BankAccount account : customer.getAccounts()) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }

        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("           ACCESS DENIED");
        System.out.println("======================================");
        System.out.println("This account does not belong to you.");
        System.out.println();

        return false;

    }

    private void balanceInquiry(Customer customer) {

        try {

            System.out.print("Account Number : ");

            String accountNumber = scanner.nextLine();

            if (!validateCustomerAccount(customer, accountNumber)) {
                return;
            }

            double balance =
                    customerService.checkBalance(accountNumber);

            System.out.println();
            System.out.println("Current Balance : Rs. " + balance);

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ==========================================
     * TRANSFER
     * ==========================================
     */

    private void transfer(Customer customer) {

        try {

            System.out.print("Source Account : ");

            String source = scanner.nextLine();

            if (!validateCustomerAccount(customer, source)) {
                return;
            }

            System.out.print("Destination Account : ");

            String destination = scanner.nextLine();

            System.out.print("Amount : ");

            double amount =
                    Double.parseDouble(scanner.nextLine());

            transactionService.transfer(
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
     * ==========================================
     * TRANSACTION HISTORY
     * ==========================================
     */

    private void transactionHistory(Customer customer) {

        try {

            System.out.print("Account Number : ");

            String accountNumber = scanner.nextLine();

            if (!validateCustomerAccount(customer, accountNumber)) {
                return;
            }

            System.out.println();

            for (Transaction transaction :
                    transactionService.getTransactionHistory(accountNumber)) {

                System.out.println(transaction);

            }

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ==========================================
     * UPDATE CONTACT
     * ==========================================
     */

    private void updateContact(Customer customer) {

        try {

            System.out.print("New Contact Number : ");

            String contact =
                    scanner.nextLine();

            customerService.updateContactNumber(
                    customer.getId(),
                    contact);

            System.out.println();
            System.out.println("Contact Updated Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ==========================================
     * UPDATE EMAIL
     * ==========================================
     */

    private void updateEmail(Customer customer) {

        try {

            System.out.print("New Email : ");

            String email =
                    scanner.nextLine();

            customerService.updateEmail(
                    customer.getId(),
                    email);

            System.out.println();
            System.out.println("Email Updated Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

}