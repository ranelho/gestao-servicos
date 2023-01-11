package com.rlti.gestaoservicos.ordemservico.application.api.os;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/os")
public interface OrdemServicoApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrdemServicoIdResponse postOS(@Valid @RequestBody OrdemServicoResquest ordemServicoResquest);

    @GetMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse getOSById(@PathVariable Long idOrdemServico);

    @GetMapping(value = "/equipamento/{idEquipamento}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse getOSByIdEquipmento(@PathVariable Long idEquipamento);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getTodasOS();

    @PatchMapping (value = "/update/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraOS(@PathVariable Long idOrdemServico,
                           @Valid @RequestBody OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    @DeleteMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaOSById(@PathVariable Long idOrdemServico);

    @GetMapping(value = "/atendimentos")
    @ResponseStatus(code = HttpStatus.OK)
    List<OrdemServicoListResponse> getAtendimentos();
}
