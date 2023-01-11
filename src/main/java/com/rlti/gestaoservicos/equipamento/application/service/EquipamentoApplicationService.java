package com.rlti.gestaoservicos.equipamento.application.service;

import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoAlteracaoRequest;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoIdResponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoListReponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
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
        setorRepository.findSetorById(equipamentoRequest.getSetor().getIdSetor());
        Equipamento exiteEquipamento = equipamentoRepository.findEquipamentoByPatrimonio(equipamentoRequest.getPatrimonio());
        if(exiteEquipamento.getPatrimonio().equalsIgnoreCase(equipamentoRequest.getPatrimonio())){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Equipamento já cadastrado!");
        }else{
            Equipamento equipamento = equipamentoRepository.salva(new Equipamento(equipamentoRequest));
            log.info("[finaliza] EquipamentoServiceApplication - portEquipamneto");
            return  EquipamentoIdResponse.builder().idEquipamento(equipamento.getIdEquipamento()).build();
        }
    }

    @Override
    public Equipamento getEquipamentoById(Long idEquipamento) {
        log.info("[inicia] EquipamentoApplicationService - getEquipamentoById");
        Equipamento equipamento = equipamentoRepository.findEquipamentoById(idEquipamento);
        log.info("[finaliza] EquipamentoApplicationService - getEquipamentoById");
        return equipamento;
    }

    @Override
    public Equipamento getEquipamentoByPatrimonio(String patrimonio) {
        log.info("[inicia] EquipamentoApplicationService - getEquipamentoByPatrimonio");
        Equipamento equipamento = equipamentoRepository.findEquipamentoByPatrimonio(patrimonio);
        log.info("[finaliza] EquipamentoApplicationService - getEquipamentoByPatrimonio");
        return equipamento;
    }

    @Override
    public List<EquipamentoListReponse> getAllEquipamentos() {
        log.info("[inicia] EquipamentoApplicationService - getAllEquipamentos");
        List<Equipamento> listaEquipamentos = equipamentoRepository.buscaEquipamentos();
        log.info("[finaliza] EquipamentoApplicationService - getAllEquipamentos");
        return EquipamentoListReponse.converte(listaEquipamentos);
    }

    @Override
    public void alteraEquipamento(Long idEquipamento, EquipamentoAlteracaoRequest equipamentoAlteracaoRequest) {
        log.info("[inicia] EquipamentoApplicationService - alteraEquipamento");
        Equipamento equipamento = getEquipamentoById(idEquipamento);
        equipamento.altera(equipamentoAlteracaoRequest);
        equipamentoRepository.salva(equipamento);
        log.info("[finaliza] EquipamentoApplicationService - alteraEquipamento");
    }

    @Override
    public void detelaEquipamento(Long idEquipamento) {
        log.info("[inicia] EquipamentoApplicationService - detelaEquipamento");
        equipamentoRepository.findEquipamentoById(idEquipamento);
        equipamentoRepository.deleta(idEquipamento);
        log.info("[inicia] EquipamentoApplicationService - detelaEquipamento");
    }
}
