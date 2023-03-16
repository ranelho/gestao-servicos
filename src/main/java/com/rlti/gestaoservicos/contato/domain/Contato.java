package com.rlti.gestaoservicos.contato.domain;

import com.rlti.gestaoservicos.contato.application.api.ContatoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID idContato;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;

    public Contato(ContatoRequest contatoRequest) {
        this.nomeCompleto = contatoRequest.getNomeCompleto();
        this.dataNascimento = contatoRequest.getDataNascimento();
        this.telefone = contatoRequest.getTelefone();
        this.endereco = contatoRequest.getEndereco();
    }
}
