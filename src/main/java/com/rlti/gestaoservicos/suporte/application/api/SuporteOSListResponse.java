package com.rlti.gestaoservicos.suporte.application.api;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import java.util.List;

import static com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse.converte;

@Value
public class SuporteOSListResponse {
    private String nome;
    private List<OrdemServicoListResponse> ordemServicos ;

    public SuporteOSListResponse(Suporte suporte) {
        this.nome = suporte.getNome();
        this.ordemServicos = converte(suporte.getOrdemServicos());
    }
}

