package menu;

import java.util.Scanner;

import config.MenuConstants;
import exceptions.GlobalExceptionHandler;
import models.users.Customer;
import models.users.Employee;
import services.authentication.AuthenticationService;
import util.InputUtil;

public class MainMenu {

    private final AuthenticationService authenticationService;

    private final ManagerMenu managerMenu;
    private final EmployeeMenu employeeMenu;
    private final CustomerMenu customerMenu;
    private final AnalystMenu analystMenu;

    private final Scanner scanner;

    public MainMenu() {

        authenticationService = new AuthenticationService();

        managerMenu = new ManagerMenu();
        employeeMenu = new EmployeeMenu();
        customerMenu = new CustomerMenu();
        analystMenu = new AnalystMenu();

        scanner = InputUtil.getScanner();

    }

    public void show() {

        initializeDefaultUsers();

        boolean exit = false;

        while (!exit) {

            try {

                System.out.println(MenuConstants.MAIN_MENU);

                int choice =
                        Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 ->
                        managerLogin();

                    case 2 ->
                        employeeLogin();

                    case 3 ->
                        customerLogin();

                    case 4 ->
                        analystLogin();

                    case 5 -> {

                        System.out.println();
                        System.out.println("Thank you for using Bank Management System.");
                        exit = true;

                    }

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
     * LOAD DEFAULT USERS
     * ==========================================
     */

    private void initializeDefaultUsers() {

        try {

            authenticationService.initializeDefaultUsers();

        }

        catch (Exception ignored) {

        }

    }

        /*
     * ==========================================
     * MANAGER LOGIN
     * ==========================================
     */

    private void managerLogin() {

        try {

            System.out.print("Employee ID : ");
            String id = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            Employee employee =
                    authenticationService.employeeLogin(id, password);

            if (authenticationService.isManager(employee)) {

                managerMenu.show(employee);

            }
            else {

                System.out.println("Access Denied.");

            }

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ==========================================
     * EMPLOYEE LOGIN
     * ==========================================
     */

    private void employeeLogin() {

        try {

            System.out.print("Employee ID : ");
            String id = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            Employee employee =
                    authenticationService.employeeLogin(id, password);

            if (authenticationService.isEmployee(employee)) {

                employeeMenu.show(employee);

            }
            else {

                System.out.println("Access Denied.");

            }

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

        /*
     * ==========================================
     * CUSTOMER LOGIN
     * ==========================================
     */

    private void customerLogin() {

        try {

            System.out.print("Customer ID : ");
            String id = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            Customer customer =
                    authenticationService.customerLogin(id, password);

            customerMenu.show(customer);

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

    /*
     * ==========================================
     * FINANCIAL ANALYST LOGIN
     * ==========================================
     */

    private void analystLogin() {

        try {

            System.out.print("Employee ID : ");
            String id = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();

            Employee employee =
                    authenticationService.employeeLogin(id, password);

            if (authenticationService.isAnalyst(employee)) {

                analystMenu.show(employee);

            }

            else {

                System.out.println();
                System.out.println("Access Denied.");
                System.out.println();

            }

        }

        catch (Exception exception) {

            GlobalExceptionHandler.handle(exception);

        }

    }

}