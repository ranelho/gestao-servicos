package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.application.service.EquipamentoService;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EquipamentoRestController implements EquipamentoApi {
    private final EquipamentoService equipamentoService;

    @Override
    public EquipamentoIdResponse postEquipamento(EquipamentoRequest equipamentoRequest) {
        log.info("[inicia] EquipamentoRestController - postEquipamento");
        EquipamentoIdResponse equipamentoIdResponse = equipamentoService.postEquipamento(equipamentoRequest);
        log.info("[finaliza] EquipamentoRestController - postEquipamento");
        return equipamentoIdResponse;
    }
}
