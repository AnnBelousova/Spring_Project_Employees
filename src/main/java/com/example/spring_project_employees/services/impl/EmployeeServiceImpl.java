package com.example.spring_project_employees.services.impl;

import com.example.spring_project_employees.exceptions.EmployeeAlreadyAddedException;
import com.example.spring_project_employees.exceptions.EmployeeNotFoundException;
import com.example.spring_project_employees.exceptions.EmployeeStorageIsFullException;
import com.example.spring_project_employees.models.Employee;
import com.example.spring_project_employees.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final int maxEmployeeCapacity = 5;
    final List<Employee> listEmployees = new ArrayList<>(
            Arrays.asList(
                    new Employee("Anna", "Belou", 1, 20000),
                    new Employee("Liza", "Limon", 3, 12000),
                    new Employee("Arina", "Kim", 2, 30000),
                    new Employee("Sergey", "Petrov", 2, 40000),
                    new Employee("Max", "Lee", 1, 35000),
                    new Employee("Lena", "Sidorova", 2, 50000)
            )
    );


    @Override
    public void addEmployee(String firstName, String lastName, Integer department, Double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (listEmployees.size() >= maxEmployeeCapacity) {
            throw new EmployeeStorageIsFullException("Capacity is full");
        } else {
            for (int i = 0; i < listEmployees.size() - 1; i++) {
                if (listEmployees.get(i).getFirstName().equals(firstName) && listEmployees.get(i).getLastName().equals(lastName)) {
                    throw new EmployeeAlreadyAddedException("Employee in list");
                } else {
                    listEmployees.add(employee);
                    System.out.println(listEmployees);
                    break;
                }
            }
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        for (Employee emp : listEmployees) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                listEmployees.remove(emp);
                System.out.println(listEmployees);
            } else {
                throw new EmployeeNotFoundException("Employee was not found");
            }
        }
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        for (Employee emp : listEmployees) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                System.out.println("Employee was find");
            } else {
                throw new EmployeeNotFoundException("Employee was not found");
            }
        }
    }

    @Override
    public List<Employee> getListEmployees() {
        return listEmployees;
    }
}
