package com.rlti.gestaoservicos.contato.application.api;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ContatoRequest {
    String nomeCompleto;
    LocalDate dataNascimento;
    String telefone;
    String endereco;
}
