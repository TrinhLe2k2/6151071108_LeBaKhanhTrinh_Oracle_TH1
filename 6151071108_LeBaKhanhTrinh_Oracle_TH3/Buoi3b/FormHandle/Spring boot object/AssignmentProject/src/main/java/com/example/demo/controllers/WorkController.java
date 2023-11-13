package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Work;
import com.example.demo.repositories.WorkRepository;

@RestController
public class WorkController {

	@Autowired
    private WorkRepository workRepository;
	@GetMapping("/works")
    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }
	
	@PostMapping("/works/post")
    public Work createWork(@RequestBody Work work) {
        return workRepository.save(work);
    }
}
