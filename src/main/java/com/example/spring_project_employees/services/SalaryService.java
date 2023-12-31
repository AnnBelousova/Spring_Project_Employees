package com.example.spring_project_employees.services;

import com.example.spring_project_employees.models.Employee;

import java.util.List;
import java.util.stream.Stream;

public interface SalaryService {

    List<Employee> emplMaxSalaryByDepartmentNumber(Integer depNumber);

    List<Employee> emplMinSalaryByDepartmentNumber(Integer depNumber);

    List<Employee> employeesByDepartmentNumber(Integer depNumber);

    List<Employee> getAllEmployees();
}
