package com.rlti.gestaoservicos.equipamento.application.service;

import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoIdResponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoReponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EquipamentoApplicationService implements EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;
    private final SetorRepository setorRepository;

    @Override
    public EquipamentoIdResponse postEquipamento(EquipamentoRequest equipamentoRequest) {
        log.info("[inicia] EquipamentoServiceApplication - portEquipamneto");
        setorRepository.buscaSetorPorId(equipamentoRequest.getSetor().getIdSetor());
        Equipamento equipamento = equipamentoRepository.salva(new Equipamento(equipamentoRequest));
        log.info("[finaliza] EquipamentoServiceApplication - portEquipamneto");
        return  EquipamentoIdResponse.builder().idEquipamento(equipamento.getIdEquipamento()).build();
    }

    @Override
    public Equipamento getEquipamentoPorId(Long idEquipamento) {
        log.info("[inicia] EquipamentoApplicationService - getEquipamentoPorId");
        Equipamento equipamento = equipamentoRepository.buscaEquipamentoPorId(idEquipamento);
        log.info("[finaliza] EquipamentoApplicationService - getEquipamentoPorId");
        return equipamento;
    }
}
