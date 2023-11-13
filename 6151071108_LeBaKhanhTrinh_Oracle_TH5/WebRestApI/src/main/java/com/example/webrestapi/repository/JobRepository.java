package com.example.webrestapi.repository;

import com.example.webrestapi.model.Department;
import com.example.webrestapi.model.Jobs;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Jobs,String> {



}
