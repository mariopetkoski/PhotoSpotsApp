package com.example.backend.service;

import com.example.backend.Exceptions.InvalidUsernameOrPasswordException;
import com.example.backend.Exceptions.UsernameAlreadyExistsException;
import com.example.backend.Exceptions.UsernameNotFoundException;
import com.example.backend.model.User;

public interface UserService {

    User register(String email, String username, String password) throws InvalidUsernameOrPasswordException, UsernameAlreadyExistsException;
    public User loadUserByUsername(String s) throws UsernameNotFoundException;
}
