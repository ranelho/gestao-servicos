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
    public EquipamentoReponse getEquipamentoById(Long idEquipamento) {
        log.info("[inicia] EquipamentoRestController - getEquipamentoById");
        Equipamento equipamento = equipamentoService.getEquipamentoById(idEquipamento);
        log.info("[finaliza] EquipamentoRestController - getEquipamentoById");
        return new EquipamentoReponse(equipamento);
    }

    @Override
    public EquipamentoReponse getEquipamentoByPatrimonio(String patrimonio) {
        log.info("[inicia] EquipamentoRestController - getEquipamentoByPatrimonio");
        Equipamento equipamento = equipamentoService.getEquipamentoByPatrimonio(patrimonio);
        log.info("[finaliza] EquipamentoRestController - getEquipamentoByPatrimonio");
        return new EquipamentoReponse(equipamento);
    }

    @Override
    public List<EquipamentoListReponse> getAllEquipamentos() {
        log.info("[inicia] EquipamentoRestController - getAllEquipamentos");
        List<EquipamentoListReponse> listaEquipamentos = equipamentoService.getAllEquipamentos();
        log.info("[finaliza] EquipamentoRestController - getAllEquipamentos");
        return listaEquipamentos;
    }

    @Override
    public void alteraEquipamento(Long idEquipamento, EquipamentoAlteracaoRequest equipamentoAlteracaoRequest) {
        log.info("[inicia] EquipamentoRestController - alteraEquipamento");
        equipamentoService.alteraEquipamento(idEquipamento, equipamentoAlteracaoRequest);
        log.info("[finaliza] EquipamentoRestController - alteraEquipamento");
    }

    @Override
    public void deletaEquipamentoById(Long idEquipamento) {
        log.info("[inicia] EquipamentoRestController - deletaEquipamentoById");
        equipamentoService.deletaEquipamento(idEquipamento);
        log.info("[finaliza] EquipamentoRestController - deletaEquipamentoById");
    }
}
