package com.example.webrestapi.service.impl;


import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Employees;
import com.example.webrestapi.repository.EmployeeRepository;
import com.example.webrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    @Transactional
    public Integer saveEmployee(Employees employee) {
        return employeeRepository.save(employee).getId();
    }

    @Override
    @Transactional
    public void update(Employees employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employees getOneEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Employees> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employees> findAllByDepartmentId(Integer departmentId) {
        return employeeRepository.findAllByDepartmentId(departmentId);
    }

    @Override
    public List<Employees> findAllEmployeeMoreSalary() {
        return employeeRepository.findAllEmployeeMoreSalary();
    }


    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return employeeRepository.existsById(id);
    }
}
