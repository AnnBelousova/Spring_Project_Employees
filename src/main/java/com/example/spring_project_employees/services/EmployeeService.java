package com.example.spring_project_employees.services;

import com.example.spring_project_employees.models.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getListEmployees();

}
