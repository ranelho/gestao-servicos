package com.rlti.gestaoservicos.usuario.domain;

import com.rlti.gestaoservicos.usuario.application.api.UsuarioRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "TB_USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true)
    @Email
    private String usuario;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "TB_USER_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @Getter
    private boolean validado;

    public Usuario(UsuarioRequest usuarioRequest, Role role) {
        this.usuario = usuarioRequest.getUsuario();
        this.password = new BCryptPasswordEncoder().encode(usuarioRequest.getPassword());
        this.roles = Collections.singletonList(role);
        this.validado = true;
    }

    public Usuario(UUID userId, String username, String password, List<GrantedAuthority> authorities) {
        this.userId = userId;
        this.usuario = username;
        this.password = password;
    }

    public static Usuario build(Usuario user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
        return new Usuario(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                authorities);
    }


    public void validaCredencial() {
        this.validado = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() { return this.getUsuario();  }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private static final long serialVersionUID = 1L;
}