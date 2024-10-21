package com.rlti.gestaoservicos.print;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("v1/print")
public interface PrintApi {

    @PostMapping("/{idOs}")
    @ResponseStatus(HttpStatus.OK)
    String gerarOsBase64(@PathVariable UUID idOs);
}
