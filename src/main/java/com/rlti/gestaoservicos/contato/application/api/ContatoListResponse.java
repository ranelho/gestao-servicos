package com.rlti.gestaoservicos.contato.application.api;

import com.rlti.gestaoservicos.contato.domain.Contato;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ContatoListResponse {
    UUID idContato;
    String nomeCompleto;
    LocalDate dataNascimento;
    String telefone;
    String endereco;

    public ContatoListResponse(Contato contato) {
        this.idContato = contato.getIdContato();
        this.nomeCompleto = contato.getNomeCompleto();
        this.dataNascimento = contato.getDataNascimento();
        this.telefone = contato.getTelefone();
        this.endereco = contato.getEndereco();
    }

    public static List<ContatoListResponse> converte(List<Contato> contato) {
        return contato.stream().map(ContatoListResponse::new).collect(Collectors.toList());
    }
}