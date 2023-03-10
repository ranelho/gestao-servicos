package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoIdResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrdemServicoApplciationService implements OrdemServicoService {
    private final OrdemServicoRepository ordemServicoRepository;
    private final EquipamentoRepository equipamentoRepository;

    @Override
    public OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest) {
        log.info("[inicia] OrdemServicoApplciationService - criaOS");
        Long idEquipamento = ordemServicoResquest.getEquipamento().getIdEquipamento();
        equipamentoRepository.findEquipamentoById(idEquipamento);
        Optional<OrdemServico> oSAtiva = ordemServicoRepository.getOSByIdEquipamento(idEquipamento);
        if (oSAtiva.isEmpty() || Situacao.FINALIZADO.equals(oSAtiva.get().getSituacao())) {
            OrdemServico ordemServico = ordemServicoRepository.salva(new OrdemServico(ordemServicoResquest));
            log.info("[finaliza] OrdemServicoApplciationService - criaOS");
            return OrdemServicoIdResponse.builder().idOrdemServico(ordemServico.getIdOrdemServico()).build();
        }else{
            throw APIException.build(HttpStatus.BAD_REQUEST, "Equipamento com ordem de serviço aberta de nº: "
                    + oSAtiva.get().getIdOrdemServico() + "!");
        }
    }

    @Override
    public OrdemServico getOSById(UUID idOrdemServico) {
        log.info("[inicia] OrdemServicoApplciationService - getOSById");
        OrdemServico ordemServico = ordemServicoRepository.findOSById(idOrdemServico);
        log.info("[finaliza] OrdemServicoApplciationService - getOSById");
        return ordemServico;
    }

    @Override
    public OrdemServico getOSByIdEquipamento(Long idEquipamento) {
        log.info("[inicia] OrdemServicoApplciationService - getOSByIdEquipamento");
        equipamentoRepository.findEquipamentoById(idEquipamento);
        OrdemServico ordemServico = ordemServicoRepository.getOSByIdEquipamento(idEquipamento)
            .orElseThrow(() -> {
                    throw APIException.build(HttpStatus.NOT_FOUND, "Equipamento sem ordem de serviço");
                }
            );
        log.info("[finaliza] OrdemServicoApplciationService - getOSByIdEquipamento");
        return ordemServico;
    }

    @Override
    public List<OrdemServicoListResponse> getAllOS() {
        log.info("[inicia] OrdemServicoApplciationService - getAllOS");
        List<OrdemServico> listOrdemServico = ordemServicoRepository.getAllOS();
        log.info("[finaliza] OrdemServicoApplciationService - getAllOS");
        return OrdemServicoListResponse.converte(listOrdemServico);
    }

    @Override
    public List<OrdemServicoListResponse> getAtendimentos() {
        log.info("[inicia] OrdemServicoApplciationService - getAtendimentos");
        List<OrdemServico> listOrdemServico = ordemServicoRepository.getAtendimentos();
        log.info("[finaliza] OrdemServicoApplciationService - getAtendimentos");
        return OrdemServicoListResponse.converte(listOrdemServico);
    }

    @Override
    public void alteraOS(UUID idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        log.info("[inicia] OrdemServicoApplciationService - alteraOS");
        OrdemServico ordemServico = ordemServicoRepository.findOSById(idOrdemServico);
        ordemServico.altera(ordemServicoAlteracaoRequest);
        ordemServicoRepository.salva(ordemServico);
        log.info("[finaliza] OrdemServicoApplciationService - alteraOS");
    }

    @Override
    public void deleta(UUID idOrdemServico) {
        log.info("[inicia] OrdemServicoApplciationService - deleta");
        ordemServicoRepository.findOSById(idOrdemServico);
        ordemServicoRepository.deleta(idOrdemServico);
        log.info("[finaliza] OrdemServicoApplciationService - deleta");
    }
}