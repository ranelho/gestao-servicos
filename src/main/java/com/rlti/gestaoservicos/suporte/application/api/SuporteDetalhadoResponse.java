package com.rlti.gestaoservicos.suporte.application.api;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;
import org.apache.catalina.LifecycleState;

import java.util.List;

import static com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse.converte;

@Value
public class SuporteDetalhadoResponse {
    private String nome;
    private String empresa;
    private List<OrdemServicoListResponse> ordemServicos ;

    public SuporteDetalhadoResponse(Suporte suporte) {
        this.nome = suporte.getNome();
        this.empresa = suporte.getEmpresa();
        this.ordemServicos = converte(suporte.getOrdemServicos());
    }
}
