package com.rlti.gestaoservicos.equipamento.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/equipamento")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public interface EquipamentoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EquipamentoIdResponse postEquipamento(@Valid @RequestBody EquipamentoRequest equipamentoRequest);

    @GetMapping(value = "/{idEquipamento}")
    @ResponseStatus(code = HttpStatus.OK)
    EquipamentoReponse getEquipamentoById(@PathVariable Long idEquipamento);

    @GetMapping(value = "/patrimonio/{patrimonio}")
    @ResponseStatus(code = HttpStatus.OK)
    EquipamentoReponse getEquipamentoByPatrimonio(@PathVariable String patrimonio);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EquipamentoListReponse> getAllEquipamentos();

    @PatchMapping(value = "/update/{idEquipamento}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraEquipamento(@PathVariable Long idEquipamento,
                           @Valid @RequestBody EquipamentoAlteracaoRequest equipamentoAlteracaoRequest);

    @DeleteMapping(value = "/{idEquipamento}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaEquipamentoById(@PathVariable Long idEquipamento);
}
