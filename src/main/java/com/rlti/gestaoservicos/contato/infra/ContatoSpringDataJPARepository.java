package com.rlti.gestaoservicos.contato.infra;

import com.rlti.gestaoservicos.contato.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContatoSpringDataJPARepository  extends JpaRepository<Contato, UUID> {
    //@Query("SELECT c FROM Contato c WHERE c.user.userId = :userId")
    Optional<Contato> findContatoByUserUserId(UUID userId);
  //  @Query(value = "select * from contato where nome_completo like :nomeCompleto% ", nativeQuery = true)
  //  @Query("SELECT c FROM Contato c WHERE c.nomeCompleto LIKE %:nomeCompleto% ")
    List<Contato> findByNomeCompletoContaining(String nomeCompleto);
}
