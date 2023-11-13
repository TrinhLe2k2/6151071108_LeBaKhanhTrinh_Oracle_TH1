package com.example.webrestapi.repository;

import com.example.webrestapi.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {


        @Query("SELECT d FROM Department d WHERE d.department_name = :name")
        List<Department> getDepartmentByName(@Param("name") String name);
        @Query("SELECT d FROM Department d  ORDER BY d.department_name ASC")

        List<Department> findAllByOrderByDepartmentNameAsc();


}
