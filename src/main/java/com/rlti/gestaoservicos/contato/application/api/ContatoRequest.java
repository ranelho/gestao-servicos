package com.rlti.gestaoservicos.contato.application.api;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ContatoRequest {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
}
