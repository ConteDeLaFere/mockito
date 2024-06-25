package com.malina.mockito.services;

import com.malina.mockito.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String name, int salary, int department);
    Employee find(String name);
    Employee remove(String name);
    List<Employee> getAllEmployees();
}
