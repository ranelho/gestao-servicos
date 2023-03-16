package com.rlti.gestaoservicos.contato.application.service;

import com.rlti.gestaoservicos.contato.application.api.ContatoRequest;
import com.rlti.gestaoservicos.contato.application.api.ContatoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class ContatoApplicationService implements ContatoService {

    @Override
    public ContatoResponse novoContato(UUID userId, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - novoContato");
        log.info("[finaliza] ContatoRestController - novoContato");
        return null;
    }
}
