package com.prjvitor.user_simples.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Substitua por lógica para buscar o usuário no banco de dados
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{noop}password") // {noop} indica que a senha não está codificada
                    .roles("ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
}