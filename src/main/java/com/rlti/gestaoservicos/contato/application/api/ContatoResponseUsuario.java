package com.rlti.gestaoservicos.contato.application.api;

import com.rlti.gestaoservicos.contato.domain.Contato;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ContatoResponseUsuario {
    String nomeCompleto;
    LocalDate dataNascimento;
    String telefone;
    String endereco;

    public ContatoResponseUsuario(Contato contato) {
        this.nomeCompleto = contato.getNomeCompleto();
        this.dataNascimento = contato.getDataNascimento();
        this.telefone = contato.getTelefone();
        this.endereco = contato.getEndereco();
    }
}
