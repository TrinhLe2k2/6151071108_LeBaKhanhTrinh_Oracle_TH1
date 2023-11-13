package com.example.webrestapi.controller;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Employees;
import com.example.webrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //Create a new employee
    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody Employees employee){
        ResponseEntity<String> responseEntity =null;
        try{
            Integer id = employeeService.   saveEmployee(employee);
            responseEntity = new ResponseEntity<String>("Employee '"+id+"' created ! ", HttpStatus.OK);

        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
   }
   //Update employee
    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody Employees employee){
        ResponseEntity<String> responseEntity =null;
        boolean available = employeeService.isAvailable(employee.getId());
        if(available){
            employeeService.update(employee);
            responseEntity = new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>("Record '"+employee.getId()+"' not found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    //Delete employee
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        boolean available = employeeService.isAvailable(id);
        if(available){
            employeeService.delete(id);
            responseEntity = new ResponseEntity<String>("Delete '"+id +"' Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>(" '"+id +"' Not Exist", HttpStatus.OK);
        }
        return  responseEntity;
    }
//Retrive/Fetch
    @GetMapping(value = "/getOneEmployee/{id}")
    public ResponseEntity getOneEmployee(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        if(employeeService.isAvailable(id)){
            Employees oneEmployee = employeeService.getOneEmployee(id);
            responseEntity = new ResponseEntity<Employees>(oneEmployee, HttpStatus.OK);
        }else{
            return new ResponseEntity("Record Not Found ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;


    }
    //Get all employees
    @GetMapping(value = "/getAllEmployee")
    public ResponseEntity getAllEmployee(){
        ResponseEntity responseEntity = null;
        List<Employees> allEmployees = employeeService.getAllEmployee();
        if(allEmployees == null || allEmployees.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Employees>>(allEmployees, HttpStatus.OK);
        }
        return responseEntity;


    }
    @GetMapping(value = "/getAllEmployeeByDepartment/{id}")
    public ResponseEntity getAllEmployeeByDepartment( Integer departmentId){
        ResponseEntity responseEntity = null;
        List<Employees> allEmployee = employeeService.findAllByDepartmentId(departmentId);
        if(allEmployee == null || allEmployee.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Employees>>(allEmployee, HttpStatus.OK);
        }
        return responseEntity;


    }
    @GetMapping(value = "/getAllEmployeeMoreSalary")
    public ResponseEntity getAllEmployeeMoreSalary( ){
        ResponseEntity responseEntity = null;
        List<Employees> allEmployee = employeeService.findAllEmployeeMoreSalary();
        if(allEmployee == null || allEmployee.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Employees>>(allEmployee, HttpStatus.OK);
        }
        return responseEntity;


    }
}
