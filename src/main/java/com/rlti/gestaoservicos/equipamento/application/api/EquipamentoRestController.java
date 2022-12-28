package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.application.service.EquipamentoService;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public EquipamentoReponse getEquipamentoPorId(Long idEquipamento) {
        log.info("[inicia] EquipamentoRestController - getEquipamentoPorId");
        Equipamento equipamento = equipamentoService.getEquipamentoPorId(idEquipamento);
        log.info("[finaliza] EquipamentoRestController - getEquipamentoPorId");
        return new EquipamentoReponse(equipamento);
    }
    @Override
    public List<EquipamentoListReponse> getTodosEquipamentos() {
        log.info("[inicia] EquipamentoRestController - getTodosEquipamentos");
        List<EquipamentoListReponse> listaEquipamentos = equipamentoService.getTodosEquipamentos();
        log.info("[finaliza] EquipamentoRestController - getTodosEquipamentos");
        return listaEquipamentos;
    }

    @Override
    public void alteraEquipamento(Long idEquipamento, EquipamentoAlteracaoRequest equipamentoAlteracaoRequest) {
        log.info("[inicia] EquipamentoRestController - alteraEquipamento");
        equipamentoService.alteraEquipamento(idEquipamento, equipamentoAlteracaoRequest);
        log.info("[finaliza] EquipamentoRestController - alteraEquipamento");
    }

    @Override
    public void deletaEquipamentoPorId(Long idEquipamento) {
        log.info("[inicia] EquipamentoRestController - deletaEquipamentoPorId");
        equipamentoService.detelaEquipamento(idEquipamento);
        log.info("[finaliza] EquipamentoRestController - deletaEquipamentoPorId");
    }
}
