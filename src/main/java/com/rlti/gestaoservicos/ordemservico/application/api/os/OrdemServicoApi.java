package com.rlti.gestaoservicos.ordemservico.application.api.os;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/os")
public interface OrdemServicoApi {
    @PostMapping
    @ResponseStatus
    OrdemServicoIdResponse postOS(@Valid @RequestBody OrdemServicoResquest ordemServicoResquest);

    @GetMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse getOSPorId(@PathVariable Long idOrdemServico);
}
