package com.rlti.gestaoservicos.ordemservico.application.api.os;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/os")
public interface OrdemServicoApi {
    @PostMapping
    @ResponseStatus
    OrdemServicoIdResponse postOS(@Valid @RequestBody OrdemServicoResquest ordemServicoResquest);

    @GetMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse getOSPorId(@PathVariable Long idOrdemServico);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getTodasOS();

    @PatchMapping (value = "/update/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraOS(@PathVariable Long idOrdemServico,
                           @Valid @RequestBody OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    @DeleteMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaOSPorId(@PathVariable Long idOrdemServico);

    @GetMapping(value = "/atendimentos")
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getAtendimentos();
}
