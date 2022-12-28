package com.rlti.gestaoservicos.equipamento.application.service;

import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoAlteracaoRequest;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoIdResponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoListReponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<EquipamentoListReponse> getTodosEquipamentos() {
        log.info("[inicia] EquipamentoApplicationService - getTodosEquipamentos");
        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaEquipamentos();
        log.info("[finaliza] EquipamentoApplicationService - getTodosEquipamentos");
        return EquipamentoListReponse.converte(listaEquipamentos);
    }

    @Override
    public void alteraEquipamento(Long idEquipamento, EquipamentoAlteracaoRequest equipamentoAlteracaoRequest) {
        log.info("[inicia] EquipamentoApplicationService - alteraEquipamento");
        Equipamento equipamento = getEquipamentoPorId(idEquipamento);
        equipamento.altera(equipamentoAlteracaoRequest);
        equipamentoRepository.salva(equipamento);
        log.info("[finaliza] EquipamentoApplicationService - alteraEquipamento");
    }

    @Override
    public void detelaEquipamento(Long idEquipamento) {
        log.info("[inicia] EquipamentoApplicationService - detelaEquipamento");
        equipamentoRepository.buscaEquipamentoPorId(idEquipamento);
        equipamentoRepository.deleta(idEquipamento);
        log.info("[inicia] EquipamentoApplicationService - detelaEquipamento");
    }
}
