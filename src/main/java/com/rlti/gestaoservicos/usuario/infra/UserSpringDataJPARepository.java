package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.usuario.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserSpringDataJPARepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserName(String userName);
}
