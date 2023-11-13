package com.example.webrestapi.service;

import com.example.webrestapi.model.Jobs;

import java.util.List;

public interface JobService {
    public String saveJob(Jobs jobs);
    public void update(Jobs jobs);
    public void delete(String id);
    public Jobs getOneJobs(String id);
    public List<Jobs> getAllJobs();

    public boolean isAvailable(String id);
}
