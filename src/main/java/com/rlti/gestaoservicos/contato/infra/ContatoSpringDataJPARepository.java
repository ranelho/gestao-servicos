package com.rlti.gestaoservicos.contato.infra;

import com.rlti.gestaoservicos.contato.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContatoSpringDataJPARepository  extends JpaRepository<Contato, UUID> {
    //@Query("SELECT c FROM Contato c WHERE c.user.userId = :userId")
    Optional<Contato> findContatoByUserUserId(UUID userId);
}
