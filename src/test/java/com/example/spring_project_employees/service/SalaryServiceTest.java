package com.example.spring_project_employees.service;

import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.EmployeeService;
import com.example.spring_project_employees.services.SalaryService;
import com.example.spring_project_employees.services.impl.EmployeeServiceImpl;
import com.example.spring_project_employees.services.impl.SalaryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalaryServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private SalaryServiceImpl salaryService;

    //    @BeforeEach
//    private void setUp(){
//        employeeService = Mockito.mock(EmployeeServiceImpl.class);
//        salaryService = new SalaryServiceImpl(employeeService);
//    }
    @Test
    public void shouldReturnEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Artem", "Ivanov", 3, 30000.00);
        Employee employee2 = new Employee("Anna", "Belou", 1, 50000.00);
        employees.add(employee1);
        employees.add(employee2);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        when(employeeService.getListEmployees()).thenReturn(employees);
        Assertions.assertEquals("Artem", employeeService.getListEmployees().get(0).getFirstName());
        Assertions.assertEquals(2, employeeService.getListEmployees().size());
    }

    @Test
    public void shouldReturnMaxSalary() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Artem", "Ivanov", 3, 30000.00);
        Employee employee2 = new Employee("Anna", "Belou", 3, 50000.00);
        employees.add(employee1);
        employees.add(employee2);

        when(employeeService.getListEmployees()).thenReturn(employees);
        Assertions.assertEquals(50000, salaryService.getMaxSalaryByDepartmentNumber(3));
    }

    @Test
    public void shouldReturnMinSalary() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Artem", "Ivanov", 3, 30000.00);
        Employee employee2 = new Employee("Anna", "Belou", 3, 50000.00);
        employees.add(employee1);
        employees.add(employee2);
        when(employeeService.getListEmployees()).thenReturn(employees);

        Assertions.assertEquals(30000, salaryService.getMinSalaryByDepartmentNumber(3));
    }

    @Test
    public void shouldReturnEmployeeByDepartmentNumber() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Artem", "Ivanov", 1, 30000.00);
        Employee employee2 = new Employee("Anna", "Belou", 1, 50000.00);
        employees.add(employee1);
        employees.add(employee2);
        when(employeeService.getListEmployees()).thenReturn(employees);
        Assertions.assertEquals(employees, salaryService.employeesByDepartmentNumber(1));
    }

    @Test
    public void shouldReturnTotalSumOfSalaryByDepartmentNumber() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Artem", "Ivanov", 3, 30000);
        Employee employee2 = new Employee("Anna", "Belou", 3, 50000);
        employees.add(employee1);
        employees.add(employee2);
        double sum = salaryService.getTotalEmployeesSumByDepartment(1);
        when(employeeService.getListEmployees()).thenReturn(employees);

        Assertions.assertEquals(80000, salaryService.getTotalEmployeesSumByDepartment(3));
    }
}
