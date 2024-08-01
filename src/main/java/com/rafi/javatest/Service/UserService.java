package com.rafi.javatest.Service;

import com.rafi.javatest.Config.RecordNotFoundException;
import com.rafi.javatest.Entity.User;
import com.rafi.javatest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new RecordNotFoundException("User not found with id: " + idUser));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}