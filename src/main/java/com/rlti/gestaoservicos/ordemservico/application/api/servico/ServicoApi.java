package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/servico")
public interface ServicoApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoIdResponse postServico(@Valid @RequestBody ServicoRequest servicoRequest);

    @GetMapping(value = "/{idServico}")
    @ResponseStatus(code = HttpStatus.OK)
    ServicoDetalhadoResponse getServicoPorId(@PathVariable Long idServico);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ServicoListResponse> getTodosServicos();

    @PatchMapping (value = "/update/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraServico(@PathVariable Long idServico, @Valid @RequestBody ServicoAlteracaoRequest servicoAlteracaoRequest);

    @DeleteMapping(value = "/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaServicoPorId(@PathVariable Long idServico);
}
