package com.example.backend.web;

import com.example.backend.model.Location;
import com.example.backend.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {


    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public String getLocationsPage(Model model){
        List<Location> locations = this.locationService.findAll();
        model.addAttribute("locations", locations);
        return "locations";
    }

    @GetMapping("/add-location")
    public String addLocationPage(Model model){
        return "addNewLocation";
    }

    @PostMapping("/add")
    public String saveLocation(
            @RequestParam (required = false) Long id,
            @RequestParam String name,
            @RequestParam String photo,
            @RequestParam double longitude,
            @RequestParam double latitude
    ) {
        if (id != null){
            this.locationService.edit(id, name, photo, longitude, latitude);
        }
        else {
            this.locationService.save(name, photo, longitude, latitude);
        }
        return "redirect:/locations";
    }

    @GetMapping("/upvote/{id}")
    public String upvoteLocation(
            @PathVariable  Long id
    ) {
       Location location = this.locationService.findById(id).get();
       int upvotes = location.getUpvotes();
       location.setUpvotes(upvotes + 1);
       String name = location.getName();
       String photo = location.getImage();
       double longitude = location.getLongitude();
       double latitude = location.getLatitude();
       this.locationService.edit(id,name, photo, longitude, latitude);
        return "redirect:/locations";
    }

    @PostMapping("/add-comment/{id}")
    public String addComment(
            @PathVariable  Long id,
            @RequestParam String comment
    ) {
        Location location = this.locationService.findById(id).get();
        location.getComments().add(comment);
        String name = location.getName();
        String photo = location.getImage();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        this.locationService.edit(id,name, photo, longitude, latitude);
        return "redirect:/locations";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.locationService.deleteById(id);
        return "redirect:/locations";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.locationService.findById(id).isPresent()) {
            Location location = this.locationService.findById(id).get();
            model.addAttribute("location", location);
            return "addNewLocation";
        }
        return "redirect:/products?error=ProductNotFound";
    }

}
