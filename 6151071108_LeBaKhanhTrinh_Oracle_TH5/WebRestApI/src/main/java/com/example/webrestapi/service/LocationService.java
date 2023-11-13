package com.example.webrestapi.service;

import com.example.webrestapi.model.Locations;

import java.util.List;

public interface LocationService {
    public Integer saveLocation(Locations locations);
    public void update(Locations locations);
    public void delete(Integer id);
    public Locations getOneLocation(Integer id);
    public List<Locations> getAllLocation();

    public boolean isAvailable(Integer id);
}
