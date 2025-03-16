package com.prjvitor.user_simples.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prjvitor.user_simples.entities.User;
import com.prjvitor.user_simples.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }   

    // Método Criar
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Método Get
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Método get all
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Método get por username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Método get por email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Método Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}