package com.rlti.gestaoservicos.contato.application.api;

import com.rlti.gestaoservicos.contato.domain.Contato;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ContatoAlteracaoResponse {
    String nomeCompleto;
    String endereco;
    String telefone;
    LocalDate dataNascimento;

    public ContatoAlteracaoResponse(Contato contato) {
        this.nomeCompleto = contato.getNomeCompleto();
        this.endereco = contato.getEndereco();
        this.telefone = contato.getTelefone();
        this.dataNascimento = contato.getDataNascimento();
    }
}