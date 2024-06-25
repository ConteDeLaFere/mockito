package com.malina.mockito.services;

import com.malina.mockito.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesInDepartment(int department);
    int getSalarySumInDepartment(int department);
    int getSalaryMaxInDepartment(int department);
    int getSalaryMinInDepartment(int department);
    Map<Integer, List<Employee>> getEmployeesByDepartment();
}
