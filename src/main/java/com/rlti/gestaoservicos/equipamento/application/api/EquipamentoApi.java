package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorDetalhadoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/equipamento")
public interface EquipamentoApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EquipamentoIdResponse postEquipamento(@Valid @RequestBody EquipamentoRequest equipamentoRequest);

    @GetMapping(value = "/{idEquipamento}")
    @ResponseStatus(code = HttpStatus.OK)
    EquipamentoReponse getEquipamentoPorId(@PathVariable Long idEquipamento);
}
