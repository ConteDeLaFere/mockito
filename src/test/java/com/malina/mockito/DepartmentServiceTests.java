package com.malina.mockito;

import com.malina.mockito.models.Employee;
import com.malina.mockito.services.DepartmentServiceImpl;
import com.malina.mockito.services.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTests {

    @Mock
    EmployeeServiceImpl employeeService;

    @InjectMocks
    DepartmentServiceImpl departmentService;

    List<Employee> employees = List.of(
            new Employee("Nick", 20000, 1),
            new Employee("Maria", 30000, 2),
            new Employee("John", 40000, 3),
            new Employee("Kate", 25000, 1),
            new Employee("Alex", 50000, 2),
            new Employee("Mike", 60000, 3)
    );

    @BeforeEach
    void setUp() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
    }

    @Test
    void maxSalaryTest() {
        int maxSalary = departmentService.getSalaryMaxInDepartment(3);
        assertEquals(60000, maxSalary);
    }

    @Test
    void minSalaryTest() {
        int minSalary = departmentService.getSalaryMinInDepartment(2);
        assertEquals(30000, minSalary);
    }

    @Test
    void sumSalaryTest() {
        int sumSalary = departmentService.getSalarySumInDepartment(3);
        assertEquals(100000, sumSalary);
    }

    @Test
    void employeesInDepartmentTest1() {
        List<Employee> employeesInDepartment = departmentService.getEmployeesInDepartment(3);
        assertEquals(2, employeesInDepartment.size());
    }

    @Test
    void employeesInDepartmentTest2() {
        List<Employee> employeesInDepartment = departmentService.getEmployeesInDepartment(3);
        List<Employee> expectedEmployees = employees.stream()
                .filter(emp -> emp.getDepartment() == 3)
                .toList();
        assertEquals(expectedEmployees, employeesInDepartment);
    }

    @Test
    void employeesByDepartmentTest() {
        Map<Integer, List<Employee>> employeesByDepartment = departmentService.getEmployeesByDepartment();
        Map<Integer, List<Employee>> expectedEmployeesByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        assertEquals(expectedEmployeesByDepartment, employeesByDepartment);
    }

}
