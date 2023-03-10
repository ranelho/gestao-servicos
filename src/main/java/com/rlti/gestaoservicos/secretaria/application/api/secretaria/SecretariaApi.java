package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/secretaria")
public interface SecretariaApi {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SecretariaIdResponse postSecretaria(@Valid @RequestBody SecretariaRequest secretariaRequest);

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(value = "/{idSecretaria}")
    @ResponseStatus(code = HttpStatus.OK)
    SecretariaDetalhadoResponse getSecretariaById(@PathVariable Long idSecretaria);

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<SecretariaListResponse> getAllSecretarias();

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping (value = "/update/{idSecretaria}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraSecretaria(@PathVariable Long idSecretaria, @Valid @RequestBody SecretariaAlteracaoRequest secretariaAlteracaoRequest);

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{idSecretaria}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaSecretariaById(@PathVariable Long idSecretaria);
}
