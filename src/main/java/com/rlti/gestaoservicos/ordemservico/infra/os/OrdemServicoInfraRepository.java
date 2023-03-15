package com.rlti.gestaoservicos.ordemservico.infra.os;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoInfraRepository implements OrdemServicoRepository {

    private final OrdemServicoSpringaDataJPARespository ordemServicoSpringaDataJPARespository;
    @Override
    public OrdemServico salva(OrdemServico ordemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - salva");
        ordemServicoSpringaDataJPARespository.save(ordemServico);
        log.info("[finaliza] OrdemServicoInfraRepository - salva");
        return ordemServico;
    }

    @Override
    public OrdemServico findOSById(UUID idOrdemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - findOSById");
        Optional<OrdemServico> optionalOrdemServico = ordemServicoSpringaDataJPARespository.findById(idOrdemServico);
        OrdemServico ordemServico = optionalOrdemServico
            .orElseThrow(() ->  {
                throw APIException.build(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada");
            });
        log.info("[finaliza] OrdemServicoInfraRepository - findOSById");
        return ordemServico;
    }

    @Override
    public Optional<OrdemServico> getOSByIdEquipamento(Long idEquipamento) {
        log.info("[inicia] OrdemServicoInfraRepository - getOSByIdEquipmento");
        Optional<OrdemServico> ordemServico = Optional.ofNullable(ordemServicoSpringaDataJPARespository.findLastOrdemServicoByIdEquipamento(idEquipamento));
        log.info("[finaliza] OrdemServicoInfraRepository - getOSByIdEquipmento");
        return ordemServico;
    }

    @Override
    public List<OrdemServico> getAllOS() {
        log.info("[inicia] OrdemServicoInfraRepository - getAllOS");
        List<OrdemServico> listOrdemServico = ordemServicoSpringaDataJPARespository.findAll();
        log.info("[inicia] OrdemServicoInfraRepository - getAllOS");
        return listOrdemServico;
    }

    @Override
    public List<OrdemServico> getOSFinalizadas() {
        log.info("[inicia] OrdemServicoInfraRepository - getAtendimentos");
        List<OrdemServico> listOrdemServico = ordemServicoSpringaDataJPARespository.findAllDistinctBySituacao(Situacao.FINALIZADO);
        log.info("[finaliza] OrdemServicoInfraRepository - getAtendimentos");
        return listOrdemServico;
    }

    @Override
    public void deleta(UUID idOrdemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - deleta");
        ordemServicoSpringaDataJPARespository.deleteById(idOrdemServico);
        log.info("[finaliza] OrdemServicoInfraRepository - deleta");
    }

    @Override
    public List<OrdemServico> getAllOSSituacao(Situacao situacao) {
        log.info("[inicia] OrdemServicoInfraRepository - getAllOSSituacao");
        List<OrdemServico> ordemServicoList = ordemServicoSpringaDataJPARespository.findAllBySituacaoAndEquipamentoIsNotNull(situacao);
        log.info("[finaliza] OrdemServicoInfraRepository - getAllOSSituacao");
        return ordemServicoList;
    }

    @Override
    public List<OrdemServico> getHistoricoEquipamento(Long idEquipamento) {
        log.info("[inicia] OrdemServicoInfraRepository - getHistoricoEquipamento");
        List<OrdemServico> ordemServicoList = ordemServicoSpringaDataJPARespository.findAllByEquipamentoIdEquipamento(idEquipamento);
        log.info("[finaliza] OrdemServicoInfraRepository - getHistoricoEquipamento");
        return ordemServicoList;
    }

    @Override
    public List<OrdemServico> getOSPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] OrdemServicoInfraRepository - getOSPeriodo");
        List<OrdemServico> ordemServicoList = ordemServicoSpringaDataJPARespository.findByDataInicialBetween(dataInicial, dataFinal);
        log.info("[finaliza] OrdemServicoInfraRepository - getOSPeriodo");
        return ordemServicoList;
    }
}