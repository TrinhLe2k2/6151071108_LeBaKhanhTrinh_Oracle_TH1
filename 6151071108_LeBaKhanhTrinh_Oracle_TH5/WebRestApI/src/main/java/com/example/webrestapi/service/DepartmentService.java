package com.example.webrestapi.service;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Locations;

import java.util.List;

public interface DepartmentService {
    public Integer saveDepartment(Department department);
    public void update(Department department);
    public void delete(Integer id);
    public Department getOneDepartment(Integer id);
    public List<Department> getAllDepartment();
    public List<Department> getDepartmentsByName(String name);
    public List<Department> findAllByOrderByDepartmentNameAsc();
    public boolean isAvailable(Integer id);
}
