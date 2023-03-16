package com.rlti.gestaoservicos.contato.application.repository;

import com.rlti.gestaoservicos.contato.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoSpringDataJPARepository  extends JpaRepository<Contato, UUID> {
}
