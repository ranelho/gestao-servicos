package com.rlti.gestaoservicos.autenticacao.application.api.request;

import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

@Value
public class LoginRequest {
	@NotBlank
	String username;

	@NotBlank
	String password;

	public UsernamePasswordAuthenticationToken getUserPassToken() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}
}
