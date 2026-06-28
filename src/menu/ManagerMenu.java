package menu;

import java.util.Scanner;

import exceptions.GlobalExceptionHandler;
import models.users.Employee;
import models.accounts.BankAccount;
import services.manager.ManagerService;
import util.InputUtil;

import enums.Department;
import enums.Designation;
import enums.Role;

import models.users.Customer;

public class ManagerMenu {

    private final ManagerService managerService;

    private final Scanner scanner;

    public ManagerMenu() {

        managerService = new ManagerService();

        scanner = InputUtil.getScanner();

    }

    public void show(Employee manager) {

        boolean logout = false;

        while (!logout) {

            try {

                System.out.println();
                System.out.println("======================================");
                System.out.println("        BANK MANAGER DASHBOARD");
                System.out.println("======================================");

                System.out.println("Logged In : "
                        + manager.getFirstName()
                        + " "
                        + manager.getLastName());

                System.out.println();

                System.out.println("1. Register Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println();

                System.out.println("5. Register Customer");
                System.out.println("6. View Customers");
                System.out.println("7. Update Customer");
                System.out.println("8. Delete Customer");
                System.out.println();

                System.out.println("9. Salary Increment");
                System.out.println("10. Bulk Salary Increment");

                System.out.println();

                System.out.println("11. Approve Loan");
                System.out.println("12. Reject Loan");
                System.out.println("13. View Loans");

                System.out.println();

                System.out.println("14. Bank Statistics");

                System.out.println();

                System.out.println("15. Logout");

                System.out.print("\nChoice : ");

                int choice =
                        Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 ->
                        registerEmployee();

                    case 2 ->
                        viewEmployees();

                    case 3 ->
                        updateEmployee();

                    case 4 ->
                        deleteEmployee();

                    case 5 ->
                        registerCustomer();

                    case 6 ->
                        viewCustomers();

                    case 7 ->
                        updateCustomer();

                    case 8 ->
                        deleteCustomer();

                    case 9 ->
                        incrementSalary();

                    case 10 ->
                        bulkIncrement();

                    case 11 ->
                        approveLoan();

                    case 12 ->
                        rejectLoan();

                    case 13 ->
                        viewLoans();

                    case 14 ->
                        managerService.displayStatistics();

                    case 15 ->
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
     * ======================================
     * MENU METHODS
     * ======================================
     */

    private void registerEmployee() {

        try {

            System.out.println();
            System.out.println("========== REGISTER EMPLOYEE ==========");

            System.out.print("Employee ID : ");
            String id = scanner.nextLine();

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

            System.out.print("DOB : ");
            String dob = scanner.nextLine();

            System.out.print("Department : ");
            Department department =
                    Department.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Designation : ");
            Designation designation =
                    Designation.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Salary : ");
            double salary =
                    Double.parseDouble(scanner.nextLine());

            Employee employee =
                    new Employee(
                            id,
                            firstName,
                            lastName,
                            email,
                            password,
                            address,
                            dob,
                            id,
                            designation,
                            department,
                            Role.BANK_EMPLOYEE,
                            salary);

            managerService.registerEmployee(employee);

            System.out.println();
            System.out.println("Employee Registered Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }


    private void viewEmployees() {

        try {

            System.out.println();
            System.out.println("==============================================================================================");
            System.out.printf("%-10s %-15s %-15s %-25s %-15s %-15s %-12s%n",
                    "ID",
                    "First Name",
                    "Last Name",
                    "Email",
                    "Department",
                    "Designation",
                    "Salary");

            System.out.println("===========================================================================================================");

            for (Employee employee : managerService.viewEmployees()) {

                System.out.printf("%-10s %-15s %-15s %-25s %-15s %-15s %-12.2f%n",

                        employee.getId(),

                        employee.getFirstName(),

                        employee.getLastName(),

                        employee.getEmail(),

                        employee.getDepartment(),

                        employee.getDesignation(),

                        employee.getSalary());

            }

            System.out.println("===========================================================================================================");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void updateEmployee() {

        try {

            System.out.println();
            System.out.println("========== UPDATE EMPLOYEE ==========");

            System.out.print("Employee ID : ");
            String employeeId = scanner.nextLine();

            Employee employee =
                    managerService.searchEmployee(employeeId);

            System.out.println();
            System.out.println("Leave blank to keep existing value.");
            System.out.println();

            System.out.print("First Name (" + employee.getFirstName() + ") : ");
            String firstName = scanner.nextLine();
            if (!firstName.isBlank()) {
                employee.setFirstName(firstName);
            }

            System.out.print("Last Name (" + employee.getLastName() + ") : ");
            String lastName = scanner.nextLine();
            if (!lastName.isBlank()) {
                employee.setLastName(lastName);
            }

            System.out.print("Email (" + employee.getEmail() + ") : ");
            String email = scanner.nextLine();
            if (!email.isBlank()) {
                employee.setEmail(email);
            }

            System.out.print("Address (" + employee.getAddress() + ") : ");
            String address = scanner.nextLine();
            if (!address.isBlank()) {
                employee.setAddress(address);
            }

            System.out.print("Department (" + employee.getDepartment() + ") : ");
            String department = scanner.nextLine();
            if (!department.isBlank()) {
                employee.setDepartment(
                        Department.valueOf(department.toUpperCase()));
            }

            System.out.print("Designation (" + employee.getDesignation() + ") : ");
            String designation = scanner.nextLine();
            if (!designation.isBlank()) {
                employee.setDesignation(
                        Designation.valueOf(designation.toUpperCase()));
            }

            System.out.print("Salary (" + employee.getSalary() + ") : ");
            String salary = scanner.nextLine();
            if (!salary.isBlank()) {
                employee.setSalary(Double.parseDouble(salary));
            }

            managerService.updateEmployee(employee);

            System.out.println();
            System.out.println("Employee Updated Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void deleteEmployee() {

        try {

            System.out.println();
            System.out.println("========== DELETE EMPLOYEE ==========");

            System.out.print("Employee ID : ");
            String employeeId = scanner.nextLine();

            Employee employee = managerService.searchEmployee(employeeId);

            System.out.println();
            System.out.println("Employee Found:");
            System.out.println(employee);

            System.out.print("\nAre you sure? (Y/N) : ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {

                managerService.deleteEmployee(employeeId);

                System.out.println();
                System.out.println("Employee Deleted Successfully.");

            } else {

                System.out.println();
                System.out.println("Deletion Cancelled.");

            }

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void registerCustomer() {

        try {

            System.out.println();
            System.out.println("========== REGISTER CUSTOMER ==========");

            System.out.print("Customer ID : ");
            String id = scanner.nextLine();

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

            System.out.print("Date of Birth : ");
            String dob = scanner.nextLine();

            System.out.print("SSN : ");
            String ssn = scanner.nextLine();

            System.out.print("Aadhaar Number : ");
            String aadhaar = scanner.nextLine();

            System.out.print("PAN Number : ");
            String pan = scanner.nextLine();

            System.out.print("Contact Number : ");
            String contact = scanner.nextLine();

            System.out.print("Account Type (SAVINGS/CHECKING): ");
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

            managerService.registerCustomer(customer, accountType);

            System.out.println();
            System.out.println("Customer Registered Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void viewCustomers() {

        try {

            System.out.println();
            System.out.println("====================================================================================================================");
            System.out.printf("%-10s %-15s %-15s %-25s %-15s %-15s %-15s%n",
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

            for (Customer customer : managerService.viewCustomers()) {

                String accountNumber = "-";
                String accountType = "-";
                double balance = 0.0;

                if (!customer.getAccounts().isEmpty()) {

                    BankAccount account = customer.getAccounts().get(0);

                    accountNumber = account.getAccountNumber();
                    accountType = account.getClass().getSimpleName();
                    balance = account.getBalance();

                }

                System.out.printf("%-10s %-15s %-15s %-25s %-15s %-15s %-15s%n",

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

    private void updateCustomer() {

        try {

            System.out.println();
            System.out.println("========== UPDATE CUSTOMER ==========");

            System.out.print("Customer ID : ");
            String customerId = scanner.nextLine();

            Customer customer =
                    managerService.searchCustomer(customerId);

            System.out.println();
            System.out.println("Leave blank to keep existing value.");
            System.out.println();

            System.out.print("First Name (" + customer.getFirstName() + ") : ");
            String firstName = scanner.nextLine();
            if (!firstName.isBlank()) {
                customer.setFirstName(firstName);
            }

            System.out.print("Last Name (" + customer.getLastName() + ") : ");
            String lastName = scanner.nextLine();
            if (!lastName.isBlank()) {
                customer.setLastName(lastName);
            }

            System.out.print("Email (" + customer.getEmail() + ") : ");
            String email = scanner.nextLine();
            if (!email.isBlank()) {
                customer.setEmail(email);
            }

            System.out.print("Address (" + customer.getAddress() + ") : ");
            String address = scanner.nextLine();
            if (!address.isBlank()) {
                customer.setAddress(address);
            }

            System.out.print("Contact Number (" + customer.getContactNumber() + ") : ");
            String contact = scanner.nextLine();
            if (!contact.isBlank()) {
                customer.setContactNumber(contact);
            }

            managerService.updateCustomer(customer);

            System.out.println();
            System.out.println("Customer Updated Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void deleteCustomer() {

        try {

            System.out.println();
            System.out.println("========== DELETE CUSTOMER ==========");

            System.out.print("Customer ID : ");
            String customerId = scanner.nextLine();

            Customer customer =
                    managerService.searchCustomer(customerId);

            System.out.println();
            System.out.println("Customer Found");
            System.out.println("--------------------------------");

            System.out.println("Customer ID : " + customer.getId());
            System.out.println("Name        : "
                    + customer.getFirstName()
                    + " "
                    + customer.getLastName());

            System.out.println("Email       : " + customer.getEmail());
            System.out.println("SSN         : " + customer.getSsn());
            System.out.println("PAN         : " + customer.getPanNo());
            System.out.println("Aadhaar     : " + customer.getAadhaarNo());

            System.out.println("--------------------------------");

            System.out.print("Are you sure you want to delete this customer? (Y/N): ");

            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {

                managerService.deleteCustomer(customerId);

                System.out.println();
                System.out.println("Customer Deleted Successfully.");

            } else {

                System.out.println();
                System.out.println("Deletion Cancelled.");

            }

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void incrementSalary() {

        try {

            System.out.print("Employee ID : ");
            String employeeId = scanner.nextLine();

            System.out.print("Increment Amount : ");
            double increment =
                    Double.parseDouble(scanner.nextLine());

            managerService.incrementEmployeeSalary(
                    employeeId,
                    increment);

            System.out.println();
            System.out.println("Salary Updated Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void bulkIncrement() {

        try {

            System.out.print("Increment Amount : ");

            double increment =
                    Double.parseDouble(scanner.nextLine());

            managerService.bulkSalaryIncrement(increment);

            System.out.println();
            System.out.println("Bulk Increment Completed.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void approveLoan() {

        try {

            System.out.print("Loan ID : ");

            String loanId = scanner.nextLine();

            managerService.approveLoan(loanId);

            System.out.println();
            System.out.println("Loan Approved Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void rejectLoan() {

        try {

            System.out.print("Loan ID : ");

            String loanId = scanner.nextLine();

            managerService.rejectLoan(loanId);

            System.out.println();
            System.out.println("Loan Rejected Successfully.");

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    private void viewLoans() {

        try {

            System.out.println();

            managerService.getAllLoans()
                    .forEach(System.out::println);

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

}