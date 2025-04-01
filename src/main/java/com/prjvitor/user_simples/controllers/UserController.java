package com.prjvitor.user_simples.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjvitor.user_simples.DTO.LoginRequest;
import com.prjvitor.user_simples.entities.User;
import com.prjvitor.user_simples.security.JwtUtil;
import com.prjvitor.user_simples.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Criar
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        User user = new User();
        user.setUsername(request.get("username"));
        user.setPassword(passwordEncoder.encode(request.get("password")));
        user.setEmail(request.get("email"));
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Deletar
    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Buscar por ID
    @GetMapping("/id/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // Buscar por Username
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // Buscar por Email
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Buscar todos
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        // Substitua pela lógica de autenticação
        if ("vitor".equals(loginRequest.getIdentifier()) && "vitor123".equals(loginRequest.getPassword())) {
            String token = JwtUtil.generateToken(loginRequest.getIdentifier()); // Gere o token JWT
            Map<String, String> response = new HashMap<>();
            response.put("token", token); // Retorne apenas o token
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body(null); // Retorne 401 se as credenciais forem inválidas
    }
}