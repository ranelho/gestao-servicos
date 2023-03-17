package com.rlti.gestaoservicos.contato.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
public class ContatoRequest {
    @NotBlank(message = "O nome é obrigatório!")
    String nomeCompleto;
    LocalDate dataNascimento;
    String telefone;
    String endereco;
}
