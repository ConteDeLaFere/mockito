package com.malina.mockito.services;

import com.malina.mockito.exceptions.EmployeeAlreadyAddedException;
import com.malina.mockito.exceptions.EmployeeNotFoundException;
import com.malina.mockito.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee add(String name, int salary, int department) {
        Employee employee = new Employee(name, salary, department);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee find(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                Employee removedEmployee = employee;
                employees.remove(employee);
                return removedEmployee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
