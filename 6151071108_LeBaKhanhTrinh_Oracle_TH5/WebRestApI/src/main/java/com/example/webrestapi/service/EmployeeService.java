package com.example.webrestapi.service;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Employees;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {
    public Integer saveEmployee(Employees employee);
    public void update(Employees employee);
    public void delete(Integer id);
    public Employees getOneEmployee(Integer id);
    public List<Employees> getAllEmployee();

    List<Employees> findAllByDepartmentId(@Param("department_id") Integer id);
    List<Employees> findAllEmployeeMoreSalary();
    public boolean isAvailable(Integer id);
}
