package com.rlti.gestaoservicos.usuario.application.repository;

import com.rlti.gestaoservicos.usuario.domain.User;

public interface UserRepository {
    User findByUserName(String username);
}
