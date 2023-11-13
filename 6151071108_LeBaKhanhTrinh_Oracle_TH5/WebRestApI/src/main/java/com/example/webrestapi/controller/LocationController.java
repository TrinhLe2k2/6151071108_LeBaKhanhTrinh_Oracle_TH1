package com.example.webrestapi.controller;

import com.example.webrestapi.model.Employees;
import com.example.webrestapi.model.Locations;
import com.example.webrestapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping(value ="/save")
    public ResponseEntity<String> save(@RequestBody Locations locations){
        ResponseEntity<String> responseEntity = null;
        try{
            Integer id = locationService.saveLocation(locations);
            responseEntity = new ResponseEntity<String>("Location '"+id+"' created ! ", HttpStatus.OK);
        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }
    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody Locations locations){
        ResponseEntity<String> responseEntity =null;
        boolean available = locationService.isAvailable(locations.getId());
        if(available){
            locationService.update(locations);
            responseEntity = new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>("Record '"+locations.getId()+"' not found", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    //Delete employee
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        boolean available = locationService.isAvailable(id);
        if(available){
            locationService.delete(id);
            responseEntity = new ResponseEntity<String>("Delete '"+id +"' Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>(" '"+id +"' Not Exist", HttpStatus.OK);
        }
        return  responseEntity;
    }
    //Retrive/Fetch
    @GetMapping(value = "/getOneLocation/{id}")
    public ResponseEntity getOneLocation(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        if(locationService.isAvailable(id)){
            Locations oneLocation = locationService.getOneLocation(id);
            responseEntity = new ResponseEntity<Locations>(oneLocation, HttpStatus.OK);
        }else{
            return new ResponseEntity("Record Not Found ", HttpStatus.NOT_FOUND);
        }
        return responseEntity;


    }
    //Get all employees
    @GetMapping(value = "/getAllLocation")
    public ResponseEntity getAllDepartment(){
        ResponseEntity responseEntity = null;
        List<Locations> allLocation = locationService.getAllLocation();
        if(allLocation == null || allLocation.isEmpty()){
            String message = "Data  Not Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Locations>>(allLocation, HttpStatus.OK);
        }
        return responseEntity;


    }

}
