package menu;

import java.util.Scanner;

import exceptions.GlobalExceptionHandler;
import models.users.Employee;
import services.data.DataAdministratorService;
import util.InputUtil;

public class DataAdminMenu {

    private final DataAdministratorService dataService;
    private final Scanner scanner;

    public DataAdminMenu() {

        dataService = new DataAdministratorService();
        scanner = InputUtil.getScanner();

    }

    public void show(Employee administrator) {

        boolean logout = false;

        while (!logout) {

            try {

                System.out.println();
                System.out.println("======================================");
                System.out.println("      DATA ADMINISTRATOR");
                System.out.println("======================================");

                System.out.println("Welcome : "
                        + administrator.getFirstName()
                        + " "
                        + administrator.getLastName());

                System.out.println();

                System.out.println("1. Backup Runtime Data");
                System.out.println("2. Restore Runtime Data");
                System.out.println("3. Data Integrity");
                System.out.println("4. System Information");
                System.out.println("5. Clear Memory");
                System.out.println("6. Logout");

                System.out.print("\nChoice : ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 ->
                            dataService.backupData();

                    case 2 ->
                            dataService.restoreData();

                    case 3 ->
                            dataService.checkIntegrity();

                    case 4 ->
                            dataService.systemInformation();

                    case 5 ->
                            dataService.clearDatabase();

                    case 6 ->
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

}