package com.rlti.gestaoservicos.contato.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/contato")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public interface ContatoApi {

    @PostMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse postContato(@PathVariable UUID userId, @Valid @RequestBody ContatoRequest contatoRequest);

    @PatchMapping("/atualiza/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void atualizaContato(@PathVariable UUID userId, @Valid @RequestBody ContatoRequest contatoRequest);

    @GetMapping("/nome/{nomeCompleto}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ContatoListResponse> getAllNome(@PathVariable String nomeCompleto);
}