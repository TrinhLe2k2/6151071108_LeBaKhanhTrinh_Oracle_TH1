package com.example.webrestapi.repository;
import com.example.webrestapi.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Locations,Integer> {

}
