package com.rlti.gestaoservicos.contato.application.repository;

import com.rlti.gestaoservicos.contato.domain.Contato;

import java.util.UUID;

public interface ContatoRepository {
    Contato salva(Contato contato);
    Contato findContato(UUID userId);
}
