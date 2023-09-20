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

    final int maxEmployeeCapacity = 10;
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
    public void addEmployee(Employee employee) {
        if (listEmployees.size() >= maxEmployeeCapacity) {
            throw new EmployeeStorageIsFullException("Capacity is full");
        } else {
            for (int i = 0; i < listEmployees.size() - 1; i++) {
                if (listEmployees.get(i).getFirstName().equals(employee.getFirstName()) && listEmployees.get(i).getLastName().equals(employee.getLastName())) {
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
        listEmployees.removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));
        System.out.println(listEmployees);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee foundEmployee = listEmployees
                .stream()
                .filter(e -> ((e.getFirstName().equals(firstName)) && (e.getLastName().equals(lastName))))
                .findFirst()
                .orElse(null);
        return foundEmployee;
    }

    @Override
    public List<Employee> getListEmployees() {
        return listEmployees;
    }
}
