package com.malina.mockito.controllers;

import com.malina.mockito.models.Employee;
import com.malina.mockito.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam int salary, @RequestParam int department) {
        return employeeService.add(name, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name) {
        return employeeService.find(name);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name) {
        return employeeService.remove(name);
    }
}
