package com.rlti.gestaoservicos.contato.application.service;

import com.rlti.gestaoservicos.contato.application.api.ContatoRequest;
import com.rlti.gestaoservicos.contato.application.api.ContatoResponse;
import com.rlti.gestaoservicos.contato.domain.Contato;

import java.util.List;
import java.util.UUID;

public interface ContatoService {
    ContatoResponse novoContato(UUID userId, ContatoRequest contatoRequest);
    void atualizaContato(UUID userId, ContatoRequest contatoRequest);
    List<Contato> getAllNome(String nomeCompleto);
}