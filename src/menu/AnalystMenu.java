package menu;

import java.util.Scanner;

import exceptions.GlobalExceptionHandler;
import models.users.Employee;
import services.report.ReportService;
import util.InputUtil;

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

                    case 1 ->
                            reportService.getEmployeeReport()
                                    .forEach(System.out::println);

                    case 2 ->
                            reportService.getCustomerReport()
                                    .forEach(System.out::println);

                    case 3 ->
                            reportService.getAccountReport()
                                    .forEach(System.out::println);

                    case 4 ->
                            reportService.getLoanReport()
                                    .forEach(System.out::println);

                    case 5 ->
                            reportService.getTransactionReport()
                                    .forEach(System.out::println);

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

}