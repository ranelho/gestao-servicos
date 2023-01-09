package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.application.service.os.OrdemServicoService;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoRestController implements OrdemServicoApi {
    private final OrdemServicoService ordemServicoService;

    @Override
    public OrdemServicoIdResponse postOS(OrdemServicoResquest ordemServicoResquest) {
        log.info("[inicia] OrdemServicoRestController - postOS");
        OrdemServicoIdResponse ordemServicoIdResponse = ordemServicoService.criaOS(ordemServicoResquest);
        log.info("[finaliza] OrdemServicoRestController - postOS");
        return ordemServicoIdResponse;
    }

    @Override
    public OrdemServicoResponse getOSPorId(Long idOrdemServico) {
        log.info("[inicia] OrdemServicoRestController - getOSPorId");
        OrdemServico ordemServico = ordemServicoService.getOSPorId(idOrdemServico);
        log.info("[finaliza] OrdemServicoRestController - getOSPorId");
        return new OrdemServicoResponse(ordemServico);
    }

    @Override
    public List<OrdemServicoListResponse> getTodasOS() {
        log.info("[inicia] OrdemServicoRestController - getTodasOS");
        List<OrdemServicoListResponse> listResponses = ordemServicoService.getTodosOS();
        log.info("[finaliza] OrdemServicoRestController - getTodasOS");
        return listResponses;
    }

    @Override
    public void alteraOS(Long idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        log.info("[inicia] OrdemServicoRestController - alteraOS");
        ordemServicoService.alteraOS(idOrdemServico, ordemServicoAlteracaoRequest);
        log.info("[finaliza] OrdemServicoRestController - alteraOS");
    }

    @Override
    public void deletaOSPorId(Long idOrdemServico) {
        log.info("[inicia] OrdemServicoRestController - deletaOSPorId");
        ordemServicoService.deleta(idOrdemServico);
        log.info("[finaliiza] OrdemServicoRestController - deletaOSPorId");
    }

    @Override
    public List<OrdemServicoListResponse> getAtendimentos() {
        log.info("[inicia] OrdemServicoRestController - getAtendimentos");
        List<OrdemServicoListResponse> listResponses = ordemServicoService.getAtendimentos();
        log.info("[finaliza] OrdemServicoRestController - getAtendimentos");
        return listResponses;
    }
}
