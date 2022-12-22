package com.rlti.gestaoservicos.suporte.application.api;

import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

@Value
public class SuporteDetalhadoResponse {
    private String nome;
    private String empresa;

    public SuporteDetalhadoResponse(Suporte suporte) {
        this.nome = suporte.getNome();
        this.empresa = suporte.getEmpresa();
    }
}
