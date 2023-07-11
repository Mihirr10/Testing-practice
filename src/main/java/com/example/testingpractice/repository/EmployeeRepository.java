package com.example.testingpractice.repository;

import com.example.testingpractice.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//  @Query("select e FROM Employee e WHERE e.departmentName =:departmentName")
//  public List<Employee> getEmployeeByDepartment(@Param("departmentName") String departmentName);

//  @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId = ?1")
//  Boolean isEmployeeExistById(Integer id);

  List<Employee> findByCompanyName(String companyName);
}
