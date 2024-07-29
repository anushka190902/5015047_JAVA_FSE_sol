import java.util.ArrayList;
import java.util.List;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (Employee emp : employees) {
            if (emp.employeeId == employeeId) {
                return emp;
            }
        }
        return null; // Employee not found
    }

    // Method to traverse and print all employees
    public void traverseEmployees() {
        System.out.println("Traversing employee records:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Method to delete an employee by ID
    public boolean deleteEmployee(int employeeId) {
        Employee emp = searchEmployee(employeeId);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Employee deleted: " + emp);
            return true;
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeManagement empMan = new EmployeeManagement();

        // Adding employees
        empMan.addEmployee(new Employee(1, "John Doe", "Manager", 75000));
        empMan.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        empMan.addEmployee(new Employee(3, "Alice Johnson", "Designer", 50000));

        // Traversing employees
        empMan.traverseEmployees();

        // Searching for an employee
        Employee emp = empMan.searchEmployee(2);
        if (emp != null) {
            System.out.println("Employee found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        boolean isDeleted = empMan.deleteEmployee(2);
        if (isDeleted) {
            empMan.traverseEmployees();
        }
    }
}
