package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SetorListResponse {

    private Long idSetor;
    private String setor;
    private String responsavel;

    public static List<SetorListResponse> converte(List<Setor> setor) {
        return setor.stream().map(SetorListResponse::new).collect(Collectors.toList());
    }

    public SetorListResponse(Setor setor) {
        this.idSetor = setor.getIdSetor();
        this.setor = setor.getSetor();
        this.responsavel = setor.getResponsavel();
    }
}
