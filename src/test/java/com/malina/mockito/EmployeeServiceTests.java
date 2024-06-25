package com.malina.mockito;

import com.malina.mockito.exceptions.EmployeeAlreadyAddedException;
import com.malina.mockito.exceptions.EmployeeNotFoundException;
import com.malina.mockito.models.Employee;
import com.malina.mockito.services.EmployeeService;
import com.malina.mockito.services.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EmployeeServiceTests {

    private final EmployeeService employeeService = new EmployeeServiceImpl();


    @BeforeEach
    public void setUp() {
        employeeService.add("Nick", 50000, 1);
        employeeService.add("Mike", 70000, 1);
        employeeService.add("Maria", 60000, 2);
        employeeService.add("Alexander", 80000, 2);
        employeeService.add("Kate", 60000, 3);
        employeeService.add("Max", 40000, 3);
    }

    @Test
    public void addTest1() {
        Employee employee = employeeService.add("Alex", 50000, 1);
        assertEquals("Alex", employee.getName());
        assertEquals(50000, employee.getSalary());
        assertEquals(1, employee.getDepartment());
    }

    @Test
    public void addTest2() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Mike", 70000, 1));
    }

    @Test
    public void removeTest1() {
        Employee employee = employeeService.remove("Nick");
        assertEquals("Nick", employee.getName());
        assertEquals(50000, employee.getSalary());
        assertEquals(1, employee.getDepartment());
    }

    @Test
    public void removeTest2() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("Helen"));
    }

    @Test
    public void findTest1() {
        Employee employee = employeeService.find("Nick");
        assertEquals("Nick", employee.getName());
        assertEquals(50000, employee.getSalary());
        assertEquals(1, employee.getDepartment());
    }

    @Test
    public void findTest2() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("Helen"));
    }

    @Test
    public void getAllEmployeesTest() {
        List<Employee> employees = List.of(
                new Employee("Nick", 50000, 1),
                new Employee("Mike", 70000, 1),
                new Employee("Maria", 60000, 2),
                new Employee("Alexander", 80000, 2),
                new Employee("Kate", 60000, 3),
                new Employee("Max", 40000, 3)
        );
        assertEquals(employees, employeeService.getAllEmployees());
    }

}
