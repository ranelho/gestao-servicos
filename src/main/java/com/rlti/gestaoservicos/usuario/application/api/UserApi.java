package com.rlti.gestaoservicos.usuario.application.api;


import com.rlti.gestaoservicos.usuario.application.api.request.RoleRuquest;
import com.rlti.gestaoservicos.usuario.application.api.request.UserRequest;
import com.rlti.gestaoservicos.usuario.application.api.response.RoleResponse;
import com.rlti.gestaoservicos.usuario.application.api.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/v1/usuario")
public interface UserApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UserResponse postUsuario(@Valid @RequestBody UserRequest usuarioRequest);

    @PostMapping("/role")
    @ResponseStatus(code = HttpStatus.CREATED)
    RoleResponse postRole(@Valid @RequestBody RoleRuquest roleRuquest);

    @GetMapping(value = "/{usuario}")
    @ResponseStatus(code = HttpStatus.OK)
    UserResponse getByUsuario(@PathVariable String usuario);
}
