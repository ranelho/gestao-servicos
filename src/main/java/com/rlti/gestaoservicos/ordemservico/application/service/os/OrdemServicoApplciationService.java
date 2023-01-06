package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoIdResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrdemServicoApplciationService implements OrdemServicoService {
    private final OrdemServicoRepository ordemServicoRepository;
    @Override
    public OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest) {
        log.info("[inicia] OrdemServicoApplciationService - criaOS");
        OrdemServico ordemServico = ordemServicoRepository.salva(new OrdemServico(ordemServicoResquest));
        log.info("[finaliza] OrdemServicoApplciationService - criaOS");
        return OrdemServicoIdResponse.builder().idOrdemServico(ordemServico.getIdOrdemServico()).build();
    }

    @Override
    public OrdemServico getOSPorId(Long idOrdemServico) {
        log.info("[inicia] OrdemServicoApplciationService - getOSPorId");
        OrdemServico ordemServico = ordemServicoRepository.buscaOSPorId(idOrdemServico);
        log.info("[finaliza] OrdemServicoApplciationService - getOSPorId");
        return ordemServico;
    }

    @Override
    public List<OrdemServicoListResponse> getTodosOS() {
        log.info("[inicia] OrdemServicoApplciationService - getTodosOS");
        List<OrdemServico> listOrdemServico = ordemServicoRepository.getTodosOS();
        log.info("[finaliza] OrdemServicoApplciationService - getTodosOS");
        return OrdemServicoListResponse.converte(listOrdemServico);
    }

    @Override
    public void alteraOS(Long idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        log.info("[inicia] OrdemServicoApplciationService - alteraOS");
        OrdemServico ordemServico = ordemServicoRepository.buscaOSPorId(idOrdemServico);
        ordemServico.altera(ordemServicoAlteracaoRequest);
        ordemServicoRepository.salva(ordemServico);
        log.info("[finaliza] OrdemServicoApplciationService - alteraOS");
    }
}
