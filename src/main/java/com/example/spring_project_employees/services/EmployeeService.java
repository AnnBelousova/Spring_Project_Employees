package com.example.spring_project_employees.services;

import com.example.spring_project_employees.models.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName, Integer department, Double salary);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);

    List<Employee> getListEmployees();
}
