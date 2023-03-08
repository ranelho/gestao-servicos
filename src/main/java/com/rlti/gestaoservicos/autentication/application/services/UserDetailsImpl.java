package com.rlti.gestaoservicos.autentication.application.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.usuario.domain.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private UUID userId;

  private String userName;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(UUID userId, String username, String password,
                         Collection<? extends GrantedAuthority> authorities) {
    this.userId = userId;
    this.userName = username;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(Usuario user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
        .collect(Collectors.toList());
    return new UserDetailsImpl(
        user.getUserId(),
        user.getUserName(),
        user.getPassword(), 
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getUsername() {
    return null;
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
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(userId, user.userId);
  }
}
