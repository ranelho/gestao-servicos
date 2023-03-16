package com.rlti.gestaoservicos.contato.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/contato")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public interface ContatoApi {

    @PostMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse postContato(@PathVariable UUID userId, @Valid @RequestBody ContatoRequest contatoRequest);

}
