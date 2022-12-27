package com.rlti.gestaoservicos.equipamento.infra;

import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Log4j2
public class EquipamentoInfraRepository implements EquipamentoRepository {
    private final EquipamentoSpringDataJPARepository equipamentoSpringDataJPARepository;

    @Override
    public Equipamento salva(Equipamento equipamento) {
        log.info("[inicia] EquipamentoInfraRepository - EquipamentoInfraRepository");
        try {
            equipamentoSpringDataJPARepository.save(equipamento);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Equipamento já cadastrado!", e);
        }
        log.info("[Finaliza] EquipamentoInfraRepository - EquipamentoInfraRepository");
        return equipamento;
    }
}
