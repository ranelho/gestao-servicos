package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/secretaria")
public interface SecretariaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SecretariaIdResponse postSecretaria(@Valid @RequestBody SecretariaRequest secretariaRequest);
}
