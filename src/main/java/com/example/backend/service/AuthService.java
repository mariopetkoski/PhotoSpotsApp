package com.example.backend.service;

import com.example.backend.Exceptions.InvalidArgumentsException;
import com.example.backend.Exceptions.InvalidUserCredentialsException;
import com.example.backend.model.User;

public interface AuthService {
    User login(String username, String password) throws InvalidArgumentsException, InvalidUserCredentialsException;
}
