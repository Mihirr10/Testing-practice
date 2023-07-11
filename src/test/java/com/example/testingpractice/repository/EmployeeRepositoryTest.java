package com.example.testingpractice.repository;

import com.example.testingpractice.entites.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;




import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

  @Autowired
  EmployeeRepository employeeRepository;

  Employee employee;

  @BeforeEach
  void setUp() {
     employee= Employee.builder()
             .employeeId(1)
             .employeeName("mihir")
             .companyName("simform")
             .department("java")
             .build();

     employeeRepository.save(employee);
  }

  @AfterEach
  void tearDown() {
        employee=null;
        employeeRepository.deleteAll();
  }


  @Test
  void testFindByCompanyName_Found(){
    List<Employee> employeeList=employeeRepository.findByCompanyName("simform");
    assertThat(employeeList.get(0).getEmployeeId()).isEqualTo(employee.getEmployeeId());
    assertThat(employeeList.get(0).getCompanyName()).isEqualTo(employee.getCompanyName());
  }

  @Test
  void testFindByCompanyName_NotFound(){
    List<Employee> employeeList=employeeRepository.findByCompanyName("amazon");
    assertThat(employeeList.isEmpty()).isTrue();
  }
}