package com.example.webrestapi.controller;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Jobs;
import com.example.webrestapi.service.DepartmentService;
import com.example.webrestapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/job")
public class JobsController {
    @Autowired
    private JobService jobService;

    @PostMapping(value ="/save")
    public ResponseEntity<String> save(@RequestBody Jobs jobs){
        ResponseEntity<String> responseEntity = null;
        try{
            String id = jobService.saveJob(jobs);
            responseEntity = new ResponseEntity<String>("Job '"+id+"' created ! ", HttpStatus.OK);
        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }
    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody Jobs jobs){
        ResponseEntity<String> responseEntity =null;
        boolean available = jobService.isAvailable(jobs.getId().toString());
        if(available){
            jobService.update(jobs);
            responseEntity = new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>("Record '"+jobs.getId()+"' not found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    //Delete employee
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        ResponseEntity responseEntity = null;
        boolean available = jobService.isAvailable(id);
        if(available){
            jobService.delete(id);
            responseEntity = new ResponseEntity<String>("Delete '"+id +"' Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>(" '"+id +"' Not Exist", HttpStatus.OK);
        }
        return  responseEntity;
    }
    //Retrive/Fetch
    @GetMapping(value = "/getOneJob/{id}")
    public ResponseEntity getOneLocation(@PathVariable String id){
        ResponseEntity responseEntity = null;
        if(jobService.isAvailable(id)){
            Jobs oneJob = jobService.getOneJobs(id);
            responseEntity = new ResponseEntity<Jobs>(oneJob, HttpStatus.OK);
        }else{
            return new ResponseEntity("Record Not Found ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;


    }
    //Get all employees
    @GetMapping(value = "/getAllJob")
    public ResponseEntity getAllJob(){
        ResponseEntity responseEntity = null;
        List<Jobs> allJob = jobService.getAllJobs();
        if(allJob == null || allJob.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Jobs>>(allJob, HttpStatus.OK);
        }
        return responseEntity;


    }
}
