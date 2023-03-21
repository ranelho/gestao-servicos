package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.equipamento.application.service.EquipamentoApplicationService;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoIdResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
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
    private final EquipamentoApplicationService equipamentoApplicationService;
    private final SetorRepository setorRepository;

    @Override
    public OrdemServicoIdResponse criaOSEquipamento(OrdemServicoResquest oSRequest) {
        log.info("[inicia] OrdemServicoApplciationService - criaOSEquipamento");
        Equipamento equipamento = equipamentoApplicationService.getEquipamentoByPatrimonio(oSRequest.getPatrimonio());
        Optional<OrdemServico> oSAtiva = ordemServicoRepository.getAtivaByEquipamentoId(equipamento.getIdEquipamento());
        if (oSAtiva.isEmpty() || oSAtiva.get().getSituacao() == Situacao.FINALIZADO){
            OrdemServico ordemServico = ordemServicoRepository.salva(new OrdemServico(oSRequest, equipamento ));
            log.info("[finaliza] OrdemServicoApplciationService - criaOSEquipamento");
            return OrdemServicoIdResponse.builder().protocolo(ordemServico.getIdOrdemServico()).build();
        }else{
            throw APIException.build(HttpStatus.BAD_REQUEST, "Equipamento com ordem de serviço aberta protocolo nº: "
                    + oSAtiva.get().getIdOrdemServico() + "!");
        }
    }

    @Override
    public OrdemServicoIdResponse criaOs(OrdemServicoResquest oSRequest) {
        log.info("[inicia] OrdemServicoApplciationService - criaOS");
        Setor setor = setorRepository.findSetorById(oSRequest.getIdSetor());
        OrdemServico ordemServico = ordemServicoRepository.salva(new OrdemServico(oSRequest, setor));
        log.info("[finaliza] OrdemServicoApplciationService - criaOS");
        return OrdemServicoIdResponse.builder().protocolo(ordemServico.getIdOrdemServico()).build();
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
        OrdemServico ordemServico = ordemServicoRepository.getAtivaByEquipamentoId(idEquipamento)
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
    public List<OrdemServicoListResponse> getOSFinalizadas() {
        log.info("[inicia] OrdemServicoApplciationService - getAtendimentos");
        List<OrdemServico> listOrdemServico = ordemServicoRepository.getOSFinalizadas();
        log.info("[finaliza] OrdemServicoApplciationService - getAtendimentos");
        return OrdemServicoListResponse.converte(listOrdemServico);
    }

    @Override
    public void alteraOS(UUID idOrdemServico, OrdemServicoAlteracaoRequest oSAlteracaoResquest) {
        log.info("[inicia] OrdemServicoApplciationService - alteraOS");
        OrdemServico ordemServico = ordemServicoRepository.findOSById(idOrdemServico);
        ordemServico.altera(oSAlteracaoResquest);
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