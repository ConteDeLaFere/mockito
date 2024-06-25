package com.malina.mockito.services;

import com.malina.mockito.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    public List<Employee> getEmployeesInDepartment(int department) {
        List<Employee> employees = getAllEmployees();
        return employees.stream().
                filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public int getSalarySumInDepartment(int department) {
        List<Employee> employees = getAllEmployees();
        return employees.stream().
                filter(employee -> employee.getDepartment() == department).
                mapToInt(Employee::getSalary).
                sum();
    }

    @Override
    public int getSalaryMaxInDepartment(int department) {
        List<Employee> employees = getAllEmployees();
        return employees.stream().
                filter(employee -> employee.getDepartment() == department).
                mapToInt(Employee::getSalary).
                max().
                orElse(0);
    }

    @Override
    public int getSalaryMinInDepartment(int department) {
        List<Employee> employees = getAllEmployees();
        return employees.stream().
                filter(employee -> employee.getDepartment() == department).
                mapToInt(Employee::getSalary).
                min().
                orElse(0);
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        List<Employee> employees = getAllEmployees();
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
