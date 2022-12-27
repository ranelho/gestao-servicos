package com.rlti.gestaoservicos.equipamento.application.service;

import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoIdResponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EquipamentoServiceApplication implements EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;

    @Override
    public EquipamentoIdResponse postEquipamento(EquipamentoRequest equipamentoRequest) {
        log.info("[inicia] EquipamentoServiceApplication - portEquipamneto");
        Equipamento equipamento = equipamentoRepository.salva(new Equipamento(equipamentoRequest));
        log.info("[finaliza] EquipamentoServiceApplication - portEquipamneto");
        return  EquipamentoIdResponse.builder().idEquipamento(equipamento.getIdEquipamento()).build();
    }
}
