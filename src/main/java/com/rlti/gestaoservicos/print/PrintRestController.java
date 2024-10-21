package com.rlti.gestaoservicos.print;

import com.rlti.gestaoservicos.print.service.PrintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PrintRestController implements PrintApi {

    private final PrintService printService;

    @Override
    public String gerarOsBase64(UUID idOs) {
        return printService.gerarOsBase64(idOs);
    }
}
