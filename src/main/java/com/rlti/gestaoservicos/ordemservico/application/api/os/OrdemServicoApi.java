package com.rlti.gestaoservicos.ordemservico.application.api.os;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/os")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public interface OrdemServicoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrdemServicoIdResponse postOS(@Valid @RequestBody OrdemServicoResquest ordemServicoResquest);

    @GetMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse getOSById(@PathVariable UUID idOrdemServico);

    @GetMapping(value = "/equipamento/{idEquipamento}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse getOSByIdEquipamento(@PathVariable Long idEquipamento);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getAllOS();

    @GetMapping(value = "/atendimentos-finalizados")
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getOSFinalizadas();

    @PatchMapping (value = "/update/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.OK)
    void alteraOS(@PathVariable UUID idOrdemServico,
                           @Valid @RequestBody OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);

    @DeleteMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaOSById(@PathVariable UUID idOrdemServico);
}