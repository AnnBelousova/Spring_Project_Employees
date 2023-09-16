package com.example.spring_project_employees.controllers;

import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.SalaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/departments")
public class SalaryController {
    final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping(path = "max-salary")
    public List<Employee> employeeMaxSalaryByDepartment(@RequestParam("department") Integer department) {
        return salaryService.emplMaxSalaryByDepartmentNumber(department);
    }

    @GetMapping(path = "min-salary")
    public List<Employee> employeeMinSalaryByDepartment(@RequestParam("department") Integer department) {
        return salaryService.emplMinSalaryByDepartmentNumber(department);
    }

    @GetMapping(path = "all-from-department")
    public List<Employee> employeesByDepartment(@RequestParam("department") Integer department) {
        return salaryService.employeesByDepartmentNumber(department);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return salaryService.getAllEmployees();
    }

}
