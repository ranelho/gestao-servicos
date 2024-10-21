package com.rlti.gestaoservicos.print.service;

import com.rlti.gestaoservicos.ordemservico.application.service.os.OrdemServicoService;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.print.api.OrdemServicoPrintResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PrintApplicationService implements PrintService {

    private final OrdemServicoService ordemServicoService;

    @Override
    public String gerarOsBase64(UUID idOs) {
        OrdemServico ordemServico = ordemServicoService.getOSById(idOs);
        OrdemServicoPrintResponse print = new OrdemServicoPrintResponse(ordemServico);
        return JasperReports.gerarContrachequeBase64(print);
    }
}
