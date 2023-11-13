package com.example.webrestapi.service.impl;
import com.example.webrestapi.model.Locations;
import com.example.webrestapi.repository.LocationRepository;
import com.example.webrestapi.service.LocationService
        ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepository;
    @Override
    @Transactional
    public Integer saveLocation(Locations locations) {
        return locationRepository.save(locations).getId();
    }

    @Override
    @Transactional
    public void update(Locations locations) {
        locationRepository.save(locations);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
    locationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Locations getOneLocation(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Locations> getAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return locationRepository.existsById(id);
    }
}
