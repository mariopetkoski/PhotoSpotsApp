package com.example.backend.service;

import com.example.backend.model.Location;

import java.util.*;

public interface LocationService {
    List<Location> findAll();

    Optional<Location> findById(long id);

    Optional<Location> findByName(String name);

    Optional<Location> save(String name, String image, double longitude, double latitude);

    Optional<Location> edit(Long id, String name, String image, double longitude, double latitude);

    void deleteById(long id);

    void upvote(long id);
}
