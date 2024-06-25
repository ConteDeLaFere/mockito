package com.malina.mockito.controllers;

import com.malina.mockito.models.Employee;
import com.malina.mockito.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/employees")
    @ResponseBody
    public List<Employee> getEmployeesInDepartment(@PathVariable int departmentId) {
        return departmentService.getEmployeesInDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/sum")
    @ResponseBody
    public int getSalarySum(@PathVariable int departmentId) {
        return departmentService.getSalarySumInDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/max")
    @ResponseBody
    public int getSalaryMax(@PathVariable int departmentId) {
        return departmentService.getSalaryMaxInDepartment(departmentId);
    }

    @GetMapping("/{departmentId}/salary/min")
    @ResponseBody
    public int getSalaryMin(@PathVariable int departmentId) {
        return departmentService.getSalaryMinInDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return departmentService.getEmployeesByDepartment();
    }

}
