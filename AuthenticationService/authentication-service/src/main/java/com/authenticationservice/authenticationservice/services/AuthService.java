package com.authenticationservice.authenticationservice.services;

import com.authenticationservice.authenticationservice.models.User;
import com.authenticationservice.authenticationservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String loginUser(String username, String password) {
        Optional<User> userOptional = findByUsername(username);
        if (userOptional.isPresent() && validatePassword(password, userOptional.get().getPassword())) {
            return "dummy_jwt_token_for_" + username; 
        }
        return null;
    }

    
    public boolean validateToken(String token) {
        return true; 
    }
}


