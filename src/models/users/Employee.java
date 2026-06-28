package models.users;

import enums.Department;
import enums.Designation;
import enums.Role;

public class Employee extends User {

    private String employeeId;

    private Designation designation;

    private Department department;

    private Role role;

    private double salary;

    public Employee() {
    }

    public Employee(String id,
                    String firstName,
                    String lastName,
                    String email,
                    String password,
                    String address,
                    String dob,
                    String employeeId,
                    Designation designation,
                    Department department,
                    Role role,
                    double salary) {

        super(id,
                firstName,
                lastName,
                email,
                password,
                address,
                dob);

        this.employeeId = employeeId;
        this.designation = designation;
        this.department = department;
        this.role = role;
        this.salary = salary;

    }

    public void updateSalary(double increment) {

        salary += increment;

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nEmployee ID : " + employeeId +
                "\nDesignation : " + designation +
                "\nDepartment  : " + department +
                "\nRole        : " + role +
                "\nSalary      : ₹" + salary;

    }

}