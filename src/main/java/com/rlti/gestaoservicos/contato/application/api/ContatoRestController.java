package com.rlti.gestaoservicos.contato.application.api;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@Log4j2
public class ContatoRestController implements ContatoApi {

    @Override
    public ContatoResponse postContato(UUID userId, ContatoRequest contatoRequest) {
        return null;
    }
}
