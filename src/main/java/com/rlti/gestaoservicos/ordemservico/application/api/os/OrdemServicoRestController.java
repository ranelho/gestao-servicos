package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.application.service.os.OrdemServicoService;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoRestController implements OrdemServicoApi {
    private final OrdemServicoService ordemServicoService;

    @Override
    public OrdemServicoIdResponse postOS(OrdemServicoResquest ordemServicoResquest) {
        log.info("[inicia] OrdemServicoRestController - postOS");
        OrdemServicoIdResponse ordemServicoIdResponse;
        if(ordemServicoResquest.getPatrimonio().isEmpty()){
            ordemServicoIdResponse = ordemServicoService.criaOs(ordemServicoResquest);
        }else {
            ordemServicoIdResponse = ordemServicoService.criaOSEquipamento(ordemServicoResquest);
        }
        log.info("[finaliza] OrdemServicoRestController - criaOSEquipamento");
        return ordemServicoIdResponse;
    }

    @Override
    public OrdemServicoResponse getOSById(UUID idOrdemServico) {
        log.info("[inicia] OrdemServicoRestController - getOSById");
        OrdemServico ordemServico = ordemServicoService.getOSById(idOrdemServico);
        log.info("[finaliza] OrdemServicoRestController - getOSById");
        return new OrdemServicoResponse(ordemServico);
    }

    @Override
    public OrdemServicoResponse getOSByIdEquipmento(Long idEquipamento) {
        log.info("[inicia] OrdemServicoRestController - getOSByIdEquipmento");
        OrdemServico ordemServico = ordemServicoService.getOSByIdEquipamento(idEquipamento);
        log.info("[finaliza] OrdemServicoRestController - getOSByIdEquipmento");
        return new OrdemServicoResponse(ordemServico);
    }

    @Override
    public List<OrdemServicoListResponse> getAllOS() {
        log.info("[inicia] OrdemServicoRestController - getAllOS");
        List<OrdemServicoListResponse> listResponses = ordemServicoService.getAllOS();
        log.info("[finaliza] OrdemServicoRestController - getAllOS");
        return listResponses;
    }

    @Override
    public List<OrdemServicoListResponse> getAtendimentos() {
        log.info("[inicia] OrdemServicoRestController - getAtendimentos");
        List<OrdemServicoListResponse> listResponses = ordemServicoService.getAtendimentos();
        log.info("[finaliza] OrdemServicoRestController - getAtendimentos");
        return listResponses;
    }

    @Override
    public void alteraOS(UUID idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        log.info("[inicia] OrdemServicoRestController - alteraOS");
        ordemServicoService.alteraOS(idOrdemServico, ordemServicoAlteracaoRequest);
        log.info("[finaliza] OrdemServicoRestController - alteraOS");
    }

    @Override
    public void deletaOSById(UUID idOrdemServico) {
        log.info("[inicia] OrdemServicoRestController - deletaOSPorId");
        ordemServicoService.deleta(idOrdemServico);
        log.info("[finaliza] OrdemServicoRestController - deletaOSPorId");
    }
}