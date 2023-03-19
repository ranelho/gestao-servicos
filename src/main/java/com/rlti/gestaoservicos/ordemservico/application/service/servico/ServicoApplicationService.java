package com.rlti.gestaoservicos.ordemservico.application.service.servico;

import com.rlti.gestaoservicos.ordemservico.application.api.servico.*;
import com.rlti.gestaoservicos.ordemservico.application.repository.servico.ServicoRepository;
import com.rlti.gestaoservicos.ordemservico.application.service.os.OrdemServicoService;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {

    private final ServicoRepository servicoRepository;
    private final OrdemServicoService ordemServicoService;

    @Override
    public ServicoIdResponse criaServico(UUID idOrdemServico, ServicoRequest servicoRequest) {
        log.info("[inicia] ServicoApplicationService - criaSecretaria");
        OrdemServico ordemServico = ordemServicoService.getOSById(idOrdemServico);
        Servico servico = servicoRepository.salva(new Servico(servicoRequest, ordemServico));
        log.info("[finaliza] ServicoApplicationService - criaSecretaria");
        return ServicoIdResponse.builder().idServico(servico.getIdServico()).build();
    }

    @Override
    public Servico findServicoById(Long idServico) {
        log.info("[inicia] ServicoApplicationService - buscaServicoById");
        Servico servico = servicoRepository.findServicoById(idServico);
        log.info("[finaliza] ServicoApplicationService - buscaServicoById");
        return servico;
    }

    @Override
    public List<ServicoListResponse> getAllServicos() {
        log.info("[inicia] ServicoApplicationService - getAllServicos");
        List<Servico> listaServico = servicoRepository.getAllServicos();
        log.info("[finaliza] ServicoApplicationService - getAllServicos");
        return ServicoListResponse.converte(listaServico);
    }

    @Override
    public void alteraServico(Long idServico, ServicoAlteracaoRequest servicoAlteracaoRequest) {
        log.info("[inicia] ServicoApplicationService - alteraSecretaria");
        Servico servico = servicoRepository.findServicoById(idServico);
        servico.altera(servicoAlteracaoRequest);
        servicoRepository.salva(servico);
        log.info("[finaliza] ServicoApplicationService - alteraSecretaria");
    }

    @Override
    public void deletaServicoById(Long idServico) {
        log.info("[inicia] ServicoApplicationService - deletaServicoById");
        findServicoById(idServico);
        servicoRepository.deleta(idServico);
        log.info("[finaliza] ServicoApplicationService - deletaServicoById");
    }
}
