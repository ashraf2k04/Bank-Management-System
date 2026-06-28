package repository;

import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;
import models.users.Employee;
import storage.MemoryStorage;

public class EmployeeRepository {

    public void addEmployee(Employee employee)
            throws DuplicateEmployeeException {

        if (MemoryStorage.employeeMap.containsKey(employee.getEmployeeId())) {

            throw new DuplicateEmployeeException(
                    "Employee ID already exists.");

        }

        if (MemoryStorage.emails.contains(employee.getEmail())) {

            throw new DuplicateEmployeeException(
                    "Email already exists.");

        }

        MemoryStorage.employeeMap.put(
                employee.getEmployeeId(),
                employee);

        MemoryStorage.emails.add(employee.getEmail());

    }

    public Employee getEmployee(String employeeId)
            throws EmployeeNotFoundException {

        Employee employee =
                MemoryStorage.employeeMap.get(employeeId);

        if (employee == null) {

            throw new EmployeeNotFoundException(
                    "Employee not found.");

        }

        return employee;

    }

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        if (!MemoryStorage.employeeMap.containsKey(employee.getEmployeeId())) {

            throw new EmployeeNotFoundException(
                    "Employee not found.");

        }

        MemoryStorage.employeeMap.put(
                employee.getEmployeeId(),
                employee);

    }

    public void deleteEmployee(String employeeId)
            throws EmployeeNotFoundException {

        Employee employee = getEmployee(employeeId);

        MemoryStorage.employeeMap.remove(employeeId);

        MemoryStorage.emails.remove(employee.getEmail());

    }

    public boolean exists(String employeeId) {

        return MemoryStorage.employeeMap.containsKey(employeeId);

    }

}