package com.rlti.gestaoservicos.configs.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.usuario.domain.Role;
import com.rlti.gestaoservicos.usuario.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;


public class UsuarioDetailsService implements UserDetails {
  private static final long serialVersionUID = 1L;

  private UUID userId;

  private String userName;

  @JsonIgnore
  private String password;
  private List<Role> roles;

  private Collection<? extends GrantedAuthority> authorities;

  public UsuarioDetailsService(UUID userId, String userName, String password,
                               Collection<? extends GrantedAuthority> authorities) {
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.authorities = authorities;
  }

  public static UsuarioDetailsService build(Usuario user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
        .collect(Collectors.toList());

    return new UsuarioDetailsService(
        user.getUserId(),
        user.getUserName(),
        user.getPassword(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UsuarioDetailsService user = (UsuarioDetailsService) o;
    return Objects.equals(userId, user.userId);
  }
}
