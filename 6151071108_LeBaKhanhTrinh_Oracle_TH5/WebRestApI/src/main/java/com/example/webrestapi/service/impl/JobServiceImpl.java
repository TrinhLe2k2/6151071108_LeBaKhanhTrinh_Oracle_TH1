package com.example.webrestapi.service.impl;

import com.example.webrestapi.model.Jobs;
import com.example.webrestapi.repository.JobRepository;
import com.example.webrestapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    @Transactional
    public String saveJob(Jobs jobs) {
        return String.valueOf(jobRepository.save(jobs).getId());
    }

    @Override
    @Transactional
    public void update(Jobs jobs) {
        jobRepository.save(jobs);
    }

    @Override
    @Transactional
    public void delete(String id) {
        jobRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Jobs getOneJobs(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Jobs> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    @Transactional
    public boolean isAvailable(String id) {
        return jobRepository.existsById(id);
    }
}
