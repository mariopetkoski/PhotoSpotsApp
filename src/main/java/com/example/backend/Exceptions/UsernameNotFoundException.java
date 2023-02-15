package com.example.backend.Exceptions;

public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException(String username) {
        super(String.format("Username %s is not found", username));
    }
}
