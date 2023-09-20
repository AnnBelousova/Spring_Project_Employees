package com.example.spring_project_employees.controllers;

import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.SalaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @GetMapping("{id}/employees")
    public List<Employee> employeesByDepartment(@PathVariable("id") Integer department) {
        return salaryService.employeesByDepartmentNumber(department);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return salaryService.getAllEmployees();
    }

    @GetMapping("{id}/salary/sum")
    public double getTotalEmployeesSumByDepartment(@PathVariable("id") Integer depNumber) {
        return salaryService.getTotalEmployeesSumByDepartment(depNumber);
    }

    @GetMapping("{id}/salary/max")
    public double getMaxSalaryByDepartment(@PathVariable("id") Integer department) {
        return salaryService.getMaxSalaryByDepartmentNumber(department);
    }

    @GetMapping("{id}/salary/min")
    public double getMinSalaryByDepartment(@PathVariable("id") Integer department) {
        return salaryService.getMinSalaryByDepartmentNumber(department);
    }
}
