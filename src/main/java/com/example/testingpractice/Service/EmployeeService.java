package com.example.testingpractice.Service;


import com.example.testingpractice.entites.Employee;
import com.example.testingpractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployee(){
    return employeeRepository.findAll();
  }

  public List<Employee> getAllEmployeeByCompanyName(String companyName){
    return employeeRepository.findByCompanyName(companyName);
  }

  public Employee getEmployee(int id){
    return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("no id found"));
  }

  public Employee addEmployee(Employee employee){
    return employeeRepository.save(employee);
  }

//  public List<Employee> getEmployeeByDepartment(String departmentName){
//    return employeeRepository.getEmployeeByDepartment(departmentName);
//  }
}
