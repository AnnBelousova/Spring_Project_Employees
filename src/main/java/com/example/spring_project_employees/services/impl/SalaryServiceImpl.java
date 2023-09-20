package com.example.spring_project_employees.services.impl;

import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.EmployeeService;
import com.example.spring_project_employees.services.SalaryService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {
    final EmployeeService employeeService;


    public SalaryServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> emplMaxSalaryByDepartmentNumber(Integer depNumber) {
        List<Employee> emplMaxSalary = employeeService.getListEmployees().stream()
                .filter(e -> e.getEmpDepartment() == depNumber)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .stream().toList();
        return emplMaxSalary;
    }

    @Override
    public List<Employee> emplMinSalaryByDepartmentNumber(Integer depNumber) {
        List<Employee> emplMinSalary = employeeService.getListEmployees().stream()
                .filter(e -> e.getEmpDepartment() == depNumber)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .stream().toList();
        return emplMinSalary;
    }

    @Override
    public List<Employee> employeesByDepartmentNumber(Integer depNumber) {
        List<Employee> employeesByDepartment = employeeService.getListEmployees().stream()
                .filter(e -> e.getEmpDepartment() == depNumber)
                .collect(Collectors.toList());
        return employeesByDepartment;
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getListEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getEmpDepartment));
    }

    @Override
    public double getTotalEmployeesSumByDepartment(Integer depNumber) {
        return employeeService.getListEmployees()
                .stream()
                .filter(e -> e.getEmpDepartment() == depNumber)
                .mapToDouble(x -> x.getSalary())
                .sum();
    }

    @Override
    public double getMaxSalaryByDepartmentNumber(Integer depNumber) {
        double emplMaxSalary = employeeService.getListEmployees().stream()
                .filter(e -> e.getEmpDepartment() == depNumber)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get()
                .getSalary();

        return emplMaxSalary;
    }

    @Override
    public double getMinSalaryByDepartmentNumber(Integer depNumber) {
        Double emplMaxSalary = employeeService.getListEmployees().stream()
                .filter(e -> e.getEmpDepartment() == depNumber)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get()
                .getSalary();
        return emplMaxSalary;
    }
}
