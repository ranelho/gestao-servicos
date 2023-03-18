package com.rlti.gestaoservicos.suporte.application.api;

import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SuporteResponse {
    String nome;

    public SuporteResponse(Suporte suporte) {
        this.nome = suporte.getNome();
    }
    public static List<SuporteResponse> converte(List<Suporte> suporteList) {
        return suporteList.stream().map(SuporteResponse::new).collect(Collectors.toList());
    }
}