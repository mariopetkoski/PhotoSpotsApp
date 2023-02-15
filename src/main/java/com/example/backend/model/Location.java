package com.example.backend.model;

import com.example.backend.util.Utils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String image;
    private double longitude;
    private double latitude;
    private int downvotes;
    private int upvotes;

    @ElementCollection
    @Column(name = "comments")
    private List<String> comments;

    public Location(long id, String name, String image, double longitude, double latitude, int downvotes, int upvotes) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.longitude = longitude;
        this.latitude = latitude;
        this.downvotes = downvotes;
        this.upvotes = upvotes;
        comments = new ArrayList<>();
    }

    public Location(String name, String image, double longitude, double latitude, int downvotes, int upvotes) {
        this.id = Utils.LocationId++;
        this.name = name;
        this.image = image;
        this.longitude = longitude;
        this.latitude = latitude;
        this.downvotes = downvotes;
        this.upvotes = upvotes;
    }

    public Location(String name, String image, double longitude, double latitude) {
        this.id = Utils.LocationId++;
        this.name = name;
        this.image = image;
        this.longitude = longitude;
        this.latitude = latitude;
        this.downvotes = 0;
        this.upvotes = 0;
    }

    //Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void increment(){
        this.upvotes++;
    }
}
