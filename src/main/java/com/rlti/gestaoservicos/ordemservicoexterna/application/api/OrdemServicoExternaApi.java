package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/os-externa")
public interface OrdemServicoExternaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrdemServicoExternaIdResponse postOsExterna(@Valid @RequestBody OrdemServicoExternaResquest externaResquest);
}
