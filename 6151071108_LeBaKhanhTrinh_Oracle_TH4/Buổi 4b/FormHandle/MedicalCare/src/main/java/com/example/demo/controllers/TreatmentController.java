package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositories.TreatmenntRepository;
import com.example.demo.models.Treatment;

@RestController
public class TreatmentController {
	@Autowired
    private TreatmenntRepository treatmenntRepository;
	@GetMapping("/treatments")
    public List<Treatment> getAllTreatments() {
        return treatmenntRepository.findAll();
    }
	
	@PostMapping("/treatments/post")
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmenntRepository.save(treatment);
    }
}
