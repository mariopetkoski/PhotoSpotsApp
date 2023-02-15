package com.example.backend.Exceptions;

public class InvalidUserCredentialsException extends Exception{
    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception");
    }
}
