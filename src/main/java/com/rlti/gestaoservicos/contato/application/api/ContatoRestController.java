package com.rlti.gestaoservicos.contato.application.api;

import com.rlti.gestaoservicos.contato.application.service.ContatoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@Log4j2
public class ContatoRestController implements ContatoApi {

    private final ContatoService contatoService;

    @Override
    public ContatoResponse postContato(UUID userId, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - postContato");
        ContatoResponse response = contatoService.novoContato(userId, contatoRequest);
        log.info("[finaliza] ContatoRestController - postContato");
        return response;
    }
}
