package com.example.backend.Exceptions;

public class InvalidUsernameOrPasswordException extends Exception{
    public InvalidUsernameOrPasswordException() {
        super("Invalid username or password");
    }
}
