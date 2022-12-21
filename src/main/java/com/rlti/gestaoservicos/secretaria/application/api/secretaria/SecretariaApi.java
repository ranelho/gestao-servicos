package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/secretaria")
public interface SecretariaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SecretariaIdResponse postSecretaria(@Valid @RequestBody SecretariaRequest secretariaRequest);

    @GetMapping(value = "/{idSecretaria}")
    @ResponseStatus(code = HttpStatus.OK)
    SecretariaDetalhadoResponse getSecretariaPorId(@PathVariable Long idSecretaria);
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<SecretariaListResponse> getTodasSecretarias();


}
