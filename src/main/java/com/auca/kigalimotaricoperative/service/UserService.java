package com.auca.kigalimotaricoperative.service;

import com.auca.kigalimotaricoperative.model.Motari;
import com.auca.kigalimotaricoperative.model.User;
import com.auca.kigalimotaricoperative.repostory.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userRepository;

    // CRUD operations for User entity

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    // Login method using Motari phone number and password
    public Optional<User> loginMotari(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User findUserById(Integer id){
        try {
            return userRepository.findByMotari(id);
        }catch (Exception e){
            return null;
        }

    }
}
