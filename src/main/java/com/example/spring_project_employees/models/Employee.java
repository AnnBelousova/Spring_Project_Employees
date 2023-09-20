package com.example.spring_project_employees.models;

import java.util.stream.Stream;

public class Employee {
    private String firstName;
    private String lastName;
    private int empDepartment;
    private double salary;

    //    public int empId;
//    public static int count;
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, int empDepartment, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empDepartment = empDepartment;
        this.salary = salary;
    }

//    public static int getCount() {
//        return count;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public int getEmplId() {
//        return empId;
//    }

    public int getEmpDepartment() {
        return empDepartment;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return
                "Full name: " + firstName +
                        " " + lastName +
                        ". Department:" + empDepartment +
                        ", salary:" + salary;
    }

}

