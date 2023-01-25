package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoExternaListResponse> getAllOSExterna();

    @GetMapping(value = "/atendimentos")
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoExternaListResponse> getAtendimentos();
}
