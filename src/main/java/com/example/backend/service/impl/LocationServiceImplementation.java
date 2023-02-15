package com.example.backend.service.impl;

import com.example.backend.model.Location;
import com.example.backend.repository.jpa.LocationRepository;
import com.example.backend.repository.static_test_repo.InMemoryLocationRepository;
import com.example.backend.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImplementation implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImplementation(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(long id) {
        return this.locationRepository.findById(id);
    }

    @Override
    public Optional<Location> findByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public Optional<Location> save(String name, String image, double longitude, double latitude) {
        return Optional.of(this.locationRepository.save(new Location(name, image, longitude, latitude)));
    }

    //not implemented
    @Override
    public Optional<Location> edit(Long id, String name, String image, double longitude, double latitude) {
        Location location = this.locationRepository.findById(id).get();
        location.setName(name);
        location.setImage(image);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        return Optional.of(this.locationRepository.save(location));
    }

    @Override
    public void deleteById(long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public void upvote(long id) {
      int upvoteOld = locationRepository.findById(id).get().getUpvotes();
      locationRepository.findById(id).get().setUpvotes(100);
    }
}
