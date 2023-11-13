package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Treatment;


public interface TreatmenntRepository extends JpaRepository<Treatment, Integer> {

}
