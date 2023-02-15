//package com.example.backend.repository;
//
//import com.example.backend.bootstrap.DataHolder;
//import com.example.backend.model.Comment;
//import com.example.backend.model.Location;
//import com.example.backend.model.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class AppRepository {
//
//    //Sega za sega samo za ova, ostanatite mozebi ponatamu
//    public List<Location> getAllPhotoSpots(double latitude, double longitude){
//        //TODO IMPLEMENT
//        //return all OK
//        return DataHolder.locations;
//    }
//    //Ova se koristi, nema potreba za site useri
//    public Optional<User> getUserById(long id){
//        //TODO IMPLEMENT
//        return DataHolder.users.stream().filter(r ->r.getId() == id).findFirst();
//    }
//
//    public Location getPhotoSpotsInArea(double latitude, double longitude){
//        //TODO IMPLEMENT
//        //get all photospots where lat, long +-1
//        return null;
//    }
//
//    public Location getTopPhotoSpots(double latitude, double longitude){
//        //TODO IMPLEMENT
//        //return top 100
//        return null;
//    }
//
//    public List<Location> getFavorites(User user){
//        //TODO IMPLEMENT
//        //get from db
//        return null;
//    }
//
//    public List<Location> getPhotoSpotsByUser(User user){
//        //TODO IMPLEMENT
//        return null;
//    }
//
//    //Ova stavi go, komentarite se baraat samo vo photospot detailed view
//    public List<Comment> getCommentsForPhotoSpot(String photoSpotID){
//        //TODO IMPLEMENT
//        //get all comments where photospot_id
//        return null;
//    }
//    //Ova stavi go
//    public void addPhotoSpot(Location spot, User user){
//        //TODO IMPLEMENT
//        //add to db
//        DataHolder.locations.add(spot);
//        DataHolder.users.add(user);
//    }
//    //Ova stavi go
//    public void addComment(Comment comment, Location location, User user){
//        //TODO IMPLEMENT
//        //add to db
//    }
//    //Ova stavi go
//    public void upvoteDownvotePhotoSpot(){
//        //TODO IMPLEMENT
//        //update photospots to have +- vote
//    }
//
//    public void deleteComment(User user, Comment comment){
//        //TODO IMPLEMENT
//        //if the user is the same as the person who created the comment, delete it
//        //maybe implement later
//    }
//    public void deletePhotoSpot(User user, Comment comment){
//        //TODO IMPLEMENT
//        //if the user is the same as the person who created the comment, delete it
//        //maybe implement later
//    }
//}
