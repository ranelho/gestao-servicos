package com.rlti.gestaoservicos.usuario.application.api.request;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class UserRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    String username;
    @NotBlank
    @Size(max = 50)
    @Email
    String email;
    String name;
    @NotBlank
    @Size(min = 6, max = 40)
    String password;
}