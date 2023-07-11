package com.example.testingpractice.controller;


import com.example.testingpractice.Service.EmployeeService;
import com.example.testingpractice.entites.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping
  public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployee();
  }

  @GetMapping("{id}")
  public Employee getEmployeeById(@PathVariable int id){
    return employeeService.getEmployee(id);
  }

  @PostMapping
  public Employee addEmployee(@RequestBody Employee employee){
    return employeeService.addEmployee(employee);
  }
//
//  @GetMapping("{departmentName}")
//  public List<Employee> getEmployeeWithDepartment(@PathVariable String departmentName){
//    return employeeService.getEmployeeByDepartment(departmentName);
//  }
}
