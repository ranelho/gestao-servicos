package com.rlti.gestaoservicos.contato.application.api;

import com.rlti.gestaoservicos.contato.application.service.ContatoService;
import com.rlti.gestaoservicos.contato.domain.Contato;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @Override
    public void atualizaContato(UUID userId, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - atualizaContato");
        contatoService.atualizaContato(userId, contatoRequest);
        log.info("[finaliza] ContatoRestController - atualizaContato");
    }

    @Override
    public List<ContatoListResponse> getAllNome(String nomeCompleto) {
        log.info("[inicia] ContatoRestController - getAllNome");
        List<Contato> contato = contatoService.getAllNome(nomeCompleto);
        log.info("[finaliza] ContatoRestController - getAllNome");
        return ContatoListResponse.converte(contato);
    }
}