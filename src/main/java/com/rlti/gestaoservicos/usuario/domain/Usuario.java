package com.rlti.gestaoservicos.usuario.domain;

import com.rlti.gestaoservicos.usuario.application.api.UsuarioRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true)
    @Email
    private String userName;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "TB_USER_ROLES",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public Usuario(UsuarioRequest usuarioRequest, Role role) {
        this.userName = usuarioRequest.getUserName();
        this.password = new BCryptPasswordEncoder().encode(usuarioRequest.getPassword());
        this.roles = Collections.singletonList(role);
    }


}