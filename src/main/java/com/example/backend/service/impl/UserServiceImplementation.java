package com.example.backend.service.impl;

import com.example.backend.Exceptions.InvalidUsernameOrPasswordException;
import com.example.backend.Exceptions.UsernameAlreadyExistsException;
import com.example.backend.Exceptions.UsernameNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.jpa.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String email, String username, String password) throws InvalidUsernameOrPasswordException, UsernameAlreadyExistsException {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
//        if (!password.equals(repeatPassword))
//            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(email, username, password);
        return userRepository.save(user);
    }
}
