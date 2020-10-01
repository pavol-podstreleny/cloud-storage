package com.pavolpodstreleny.CloudStorage.service;

import java.security.Principal;
import java.security.SecureRandom;
import java.util.Base64;

import com.pavolpodstreleny.CloudStorage.entity.User;
import com.pavolpodstreleny.CloudStorage.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HashService hashService;

    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);

        return userMapper.insert(new User(null, encodedSalt, user.getFirstName(), user.getLastName(),
                user.getUsername(), hashedPassword));
    }

    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    public Integer getCurrentUserId(Principal principal) {
        return getUser(principal.getName()).getUserId();
    }
}