package com.rlti.gestaoservicos.contato.application.api;

import com.rlti.gestaoservicos.contato.domain.Contato;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ContatoResponse {
    UUID idContato;
    String nomeCompleto;
    LocalDate dataNascimento;
    String telefone;
    String endereco;

    public ContatoResponse(Contato contato) {
        this.idContato = contato.getIdContato();
        this.nomeCompleto = contato.getNomeCompleto();
        this.dataNascimento = contato.getDataNascimento();
        this.telefone = contato.getTelefone();
        this.endereco = contato.getEndereco();
    }
}