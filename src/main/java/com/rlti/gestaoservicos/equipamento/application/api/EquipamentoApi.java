package com.rlti.gestaoservicos.equipamento.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/equipamento")
public interface EquipamentoApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EquipamentoIdResponse postEquipamento(@Valid @RequestBody EquipamentoRequest equipamentoRequest);
}
