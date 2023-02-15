package com.example.backend.bootstrap;

import com.example.backend.model.Location;
import com.example.backend.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Location> locations = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        locations.add(new Location("TestSpot1", "url1", 12, 15, 8, 8));
        locations.add(new Location( "TestSpot2", "url2", 12, 15, 8, 8));
        locations.add(new Location( "TestSpot3", "url3", 12, 15, 8, 8));

        users.add(new User( "email", "username1", "password"));
        users.add(new User( "emailll", "usssername1", "password"));
    }
}
