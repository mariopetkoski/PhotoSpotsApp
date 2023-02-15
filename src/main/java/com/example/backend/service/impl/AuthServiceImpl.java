package com.example.backend.service.impl;

import com.example.backend.Exceptions.InvalidArgumentsException;
import com.example.backend.Exceptions.InvalidUserCredentialsException;
import com.example.backend.model.User;
import com.example.backend.repository.jpa.UserRepository;
import com.example.backend.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) throws InvalidArgumentsException, InvalidUserCredentialsException {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
