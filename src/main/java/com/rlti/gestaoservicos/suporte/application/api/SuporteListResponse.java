package com.rlti.gestaoservicos.suporte.application.api;

import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaListResponse;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SuporteListResponse {
    private String nome;
    private String empresa;

    public SuporteListResponse(Suporte suporte) {
        this.nome = suporte.getNome();
        this.empresa = suporte.getEmpresa();
    }
    public static List<SuporteListResponse> converte(List<Suporte> suporteList) {
        return suporteList.stream().map(SuporteListResponse::new).collect(Collectors.toList());
    }

}
