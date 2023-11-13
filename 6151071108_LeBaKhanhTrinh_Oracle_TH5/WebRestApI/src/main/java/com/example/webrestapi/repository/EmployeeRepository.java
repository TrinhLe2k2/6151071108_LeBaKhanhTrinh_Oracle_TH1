package com.example.webrestapi.repository;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees,Integer> {

    @Query("SELECT e FROM Employees e WHERE e.department.id = :department_id")
    List<Employees> findAllByDepartmentId(@Param("department_id") Integer id);
    @Query("SELECT e FROM Employees e,Jobs  j WHERE e.salary > j.max_salary ")
    List<Employees> findAllEmployeeMoreSalary();
}
