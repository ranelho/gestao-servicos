package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/servico")
public interface ServicoApi {
    @PostMapping(value = "/os")
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoIdResponse postServico(@Valid @RequestBody ServicoRequest servicoRequest);

    @PostMapping(value = "/os-externa")
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoIdResponse postServico(@Valid @RequestBody ServicoOSExternaRequest servicoRequest);

    @GetMapping(value = "/{idServico}")
    @ResponseStatus(code = HttpStatus.OK)
    ServicoDetalhadoResponse getServicoById(@PathVariable Long idServico);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ServicoListResponse> getAllServicos();

    @PatchMapping (value = "/update/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraServico(@PathVariable Long idServico, @Valid @RequestBody ServicoAlteracaoRequest servicoAlteracaoRequest);

    @DeleteMapping(value = "/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaServicoById(@PathVariable Long idServico);
}
