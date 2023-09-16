package com.example.spring_project_employees.controllers;

import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeService employeeService;
    Employee employee;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName, @RequestParam("department") Integer department, @RequestParam("salary") Double salary) {
        employee = new Employee(firstName, lastName, department, salary);
        employeeService.addEmployee(firstName, lastName, department, salary);
        return employee;
    }

    @GetMapping(path = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(firstName, lastName);
        return employee;
    }

    @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee findEmployee(@RequestParam("firstName") String firstName, String lastName) {
        employee = new Employee(firstName, lastName);
        employeeService.findEmployee(firstName, lastName);
        return employee;
    }
}
