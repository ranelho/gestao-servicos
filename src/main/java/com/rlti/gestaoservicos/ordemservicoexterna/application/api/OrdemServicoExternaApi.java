package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/os-externa")
public interface OrdemServicoExternaApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrdemServicoExternaIdResponse postOsExterna(@Valid @RequestBody OrdemServicoExternaResquest externaResquest);

    @GetMapping(value = "/{idOrdemServicoExterna}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoExternaResponse getOSExternaById(@PathVariable UUID idOrdemServicoExterna);
}
