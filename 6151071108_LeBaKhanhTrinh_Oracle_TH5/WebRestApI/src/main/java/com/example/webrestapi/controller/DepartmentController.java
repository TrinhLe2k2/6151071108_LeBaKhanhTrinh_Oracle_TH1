package com.example.webrestapi.controller;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Locations;
import com.example.webrestapi.service.DepartmentService;
import com.example.webrestapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value ="/save")
    public ResponseEntity<String> save(@RequestBody Department department){
        ResponseEntity<String> responseEntity = null;
        try{
            Integer id = departmentService.saveDepartment(department);
            responseEntity = new ResponseEntity<String>("Department '"+id+"' created ! ", HttpStatus.OK);
        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }
    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody Department department){
        ResponseEntity<String> responseEntity =null;
        boolean available = departmentService.isAvailable(department.getId());
        if(available){
            departmentService.update(department);
            responseEntity = new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>("Record '"+department.getId()+"' not found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    //Delete employee
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        boolean available = departmentService.isAvailable(id);
        if(available){
            departmentService.delete(id);
            responseEntity = new ResponseEntity<String>("Delete '"+id +"' Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>(" '"+id +"' Not Exist", HttpStatus.OK);
        }
        return  responseEntity;
    }
    //Retrive/Fetch
    @GetMapping(value = "/getOneDepartment/{id}")
    public ResponseEntity getOneLocation(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        if(departmentService.isAvailable(id)){
            Department oneDepartment = departmentService.getOneDepartment(id);
            responseEntity = new ResponseEntity<Department>(oneDepartment, HttpStatus.OK);
        }else{
            return new ResponseEntity("Record Not Found ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;


    }
    //Get all employees
    @GetMapping(value = "/getAllDepartment")
    public ResponseEntity getAllDepartmentById(){
        ResponseEntity responseEntity = null;
        List<Department> allDepartment = departmentService.getAllDepartment();
        if(allDepartment == null || allDepartment.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Department>>(allDepartment, HttpStatus.OK);
        }
        return responseEntity;


    }
    @GetMapping(value = "/getDepartmentByName/{name}")
    public ResponseEntity getDepartmentByName(String name){
        ResponseEntity responseEntity = null;
       List<Department> allDepartment = departmentService.getDepartmentsByName(name);
        if(allDepartment == null || allDepartment.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Department>>(allDepartment, HttpStatus.OK);
        }
        return responseEntity;


    }
    @GetMapping(value = "/getAllDepartmentOrderByName")
    public ResponseEntity getDepartmentByName(){
        ResponseEntity responseEntity = null;
        List<Department> allDepartment = departmentService.findAllByOrderByDepartmentNameAsc();
        if(allDepartment == null || allDepartment.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Department>>(allDepartment, HttpStatus.OK);
        }
        return responseEntity;


    }


}
