package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {

}
