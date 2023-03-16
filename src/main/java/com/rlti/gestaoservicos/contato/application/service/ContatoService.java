package com.rlti.gestaoservicos.contato.application.service;

import com.rlti.gestaoservicos.contato.application.api.ContatoRequest;
import com.rlti.gestaoservicos.contato.application.api.ContatoResponse;

import java.util.UUID;

public interface ContatoService {
    ContatoResponse novoContato(UUID userId, ContatoRequest contatoRequest);
}
