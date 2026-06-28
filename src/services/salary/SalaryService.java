package services.salary;

import models.users.Employee;
import repository.BankRepository;

public class SalaryService {

    private final BankRepository bankRepository;

    public SalaryService() {

        bankRepository = new BankRepository();

    }

    /*
     * ==========================================
     * INCREMENT INDIVIDUAL EMPLOYEE
     * ==========================================
     */

    public void incrementSalary(Employee employee,
                                double incrementAmount) {

        employee.updateSalary(incrementAmount);

    }

    /*
     * ==========================================
     * BULK INCREMENT
     * ==========================================
     */

    public void bulkIncrement(double incrementAmount) {

        for (Employee employee :
                bankRepository.getAllEmployees()) {

            employee.updateSalary(incrementAmount);

        }

    }

    /*
     * ==========================================
     * DESIGNATION WISE INCREMENT
     * ==========================================
     */

    public void designationWiseIncrement() {

        for (Employee employee :
                bankRepository.getAllEmployees()) {

            switch (employee.getDesignation()) {

                case CLERK ->
                        employee.updateSalary(1000);

                case ACCOUNTANT ->
                        employee.updateSalary(2000);

                case MANAGER ->
                        employee.updateSalary(
                                employee.getSalary() * 0.10);

            }

        }

    }

}