package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrdemServicoApplciationService implements OrdemServicoService {
    private final OrdemServicoRepository ordemServicoRepository;
/*    @Override
    public OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest) {
        log.info("[inicia] OrdemServicoApplciationService - criaOS");
        OrdemServico ordemServico = ordemServicoRepository.salva(new OrdemServico(ordemServicoResquest));
        log.info("[finaliza] OrdemServicoApplciationService - criaOS");
        return OrdemServicoIdResponse.builder().idOrdemSercvico(ordemServico.getIdOrdemServico()).build();
    }*/
}
