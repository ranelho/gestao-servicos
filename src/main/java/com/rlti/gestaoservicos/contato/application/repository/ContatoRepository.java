package com.rlti.gestaoservicos.contato.application.repository;

import com.rlti.gestaoservicos.contato.domain.Contato;

import java.util.List;
import java.util.UUID;

public interface ContatoRepository {
    Contato salva(Contato contato);
    Contato findContato(UUID userId);
    List<Contato> getAllNome(String nomeCompleto);
}