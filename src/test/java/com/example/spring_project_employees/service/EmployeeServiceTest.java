package com.example.spring_project_employees.service;

import com.example.spring_project_employees.exceptions.EmployeeAlreadyAddedException;
import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.EmployeeService;
import com.example.spring_project_employees.services.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee("Anna", "Belou", 3, 10000.00);

        EmployeeAlreadyAddedException exc = Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.addEmployee(employee);
        });
        Assertions.assertEquals("Employee in list", exc.getMessage());
    }

    @Test
    public void shouldRemoveEmployee() {
        Employee employee = new Employee("Artem", "Ivanov", 3, 10000.00);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee("Artem", "Ivanov");
        Assertions.assertEquals(null, employeeService.findEmployee("Artem", "Ivanov"));
    }

    @Test
    public void shouldFindEmployee() {
        Employee employee = new Employee("Artem", "Ivanov", 3, 10000.00);
        employeeService.addEmployee(employee);
        Assertions.assertEquals(employeeService.findEmployee("Artem", "Ivanov"), employee);
    }

    @Test
    public void shouldReturnEmployeeList() {
        Assertions.assertEquals(6, employeeService.getListEmployees().size());
    }

}
