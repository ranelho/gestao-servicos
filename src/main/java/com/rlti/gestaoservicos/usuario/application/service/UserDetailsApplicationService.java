package com.rlti.gestaoservicos.usuario.application.service;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.usuario.application.repository.UserRepository;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsApplicationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("[inicia] UserDetailsApplicationService - loadUserByUsername");
        User user = userRepository.findByUserName(username);
        log.info("[finaliza] UserDetailsApplicationService - loadUserByUsername");
        return user;
    }
}
