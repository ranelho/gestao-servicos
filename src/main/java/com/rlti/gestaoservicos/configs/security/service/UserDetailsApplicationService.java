package com.rlti.gestaoservicos.configs.security.service;

import com.rlti.gestaoservicos.usuario.application.repository.UsuarioRepository;
import com.rlti.gestaoservicos.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Log4j2
@Transactional
public class UserDetailsApplicationService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("[inicia] UserDetailsApplicationService - loadUserByUsername");
        Usuario usuario = usuarioRepository.findByUsuario(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Não existe credencial para o Usuario informado: "+ userName));
        log.info("[finaliza] UserDetailsApplicationService - loadUserByUsername");
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }
}
