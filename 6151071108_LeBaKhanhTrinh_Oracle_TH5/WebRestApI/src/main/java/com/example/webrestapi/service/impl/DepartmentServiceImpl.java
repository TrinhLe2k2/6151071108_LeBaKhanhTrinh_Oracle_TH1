package com.example.webrestapi.service.impl;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.repository.DepartmentRepository;
import com.example.webrestapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    @Transactional
    public Integer saveDepartment(Department department) {
        return departmentRepository.save(department).getId();
    }

    @Override
    @Transactional
    public void update(Department department) {
         departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Department getOneDepartment(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public List<Department> getDepartmentsByName(String name) {
        return departmentRepository.getDepartmentByName(name);
    }

    @Override
    public List<Department> findAllByOrderByDepartmentNameAsc() {
        return departmentRepository.findAllByOrderByDepartmentNameAsc();
    }


    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return departmentRepository.existsById(id);
    }
}
