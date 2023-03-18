package com.rlti.gestaoservicos.contato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.contato.application.api.ContatoRequest;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID idContato;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Contato(ContatoRequest contatoRequest, User user) {
        this.user = user;
        this.nomeCompleto = contatoRequest.getNomeCompleto().toUpperCase();
        this.dataNascimento = contatoRequest.getDataNascimento();
        this.telefone = contatoRequest.getTelefone();
        this.endereco = contatoRequest.getEndereco().toUpperCase();
    }

    public void atualiza(ContatoRequest contatoRequest) {
        this.nomeCompleto =  contatoRequest.getNomeCompleto().toUpperCase();
        this.dataNascimento = contatoRequest.getDataNascimento();
        this.telefone = contatoRequest.getTelefone();
        this.endereco = contatoRequest.getEndereco().toUpperCase();
    }
}