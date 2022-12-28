package com.rlti.gestaoservicos.equipamento.infra;

import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Log4j2
public class EquipamentoInfraRepository implements EquipamentoRepository {
    private final EquipamentoSpringDataJPARepository equipamentoSpringDataJPARepository;
    @Override
    public Equipamento salva(Equipamento equipamento) {
        log.info("[inicia] EquipamentoInfraRepository - EquipamentoInfraRepository");
        equipamentoSpringDataJPARepository.save(equipamento);
        log.info("[Finaliza] EquipamentoInfraRepository - EquipamentoInfraRepository");
        return equipamento;
    }

    @Override
    public Equipamento buscaEquipamentoPorId(Long idEquipamento) {
        log.info("[inicia] EquipamentoInfraRepository - buscaEquipamentoPorId");
        Optional<Equipamento> optionalEquipamento = equipamentoSpringDataJPARepository.findById(idEquipamento);
        Equipamento equipamento = optionalEquipamento
                .orElseThrow(() ->  {
                    throw APIException.build(HttpStatus.NOT_FOUND, "Equipamento não encontrado");
                }
        );
        log.info("[finaliza] EquipamentoInfraRepository - buscaEquipamentoPorId");
        return equipamento;
    }

    @Override
    public List<Equipamento> buscaEquipamentos() {
        log.info("[inicia] EquipamentoInfraRepository - buscaEquipamentos");
        List<Equipamento> equipamentos = equipamentoSpringDataJPARepository.findAll();
        log.info("[finaliza] EquipamentoInfraRepository - buscaEquipamentos");
        return equipamentos;
    }
}
