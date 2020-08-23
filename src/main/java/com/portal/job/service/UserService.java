package com.portal.job.service;

import com.portal.job.domain.User;
import com.portal.job.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getOrSave(User user) {
        User existingUser = userRepository.find(user.getUsername());
        if (existingUser == null)
            userRepository.save(user);
        return user;
    }

    public User getUser(String username) {
        return userRepository.find(username);
    }
}
