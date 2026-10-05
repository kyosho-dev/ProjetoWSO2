package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TransactionDTO.BilheteRequest;
import com.example.demo.TransactionDTO.BilheteResponse;

@RestController
@RequestMapping("/v1/bilhetes")
public class BilhetadorController {
    @PostMapping("/processar")
    public ResponseEntity<BilheteResponse> processarBilhete(@RequestBody BilheteRequest request) {
        // Cálculo da bilhetagem
        long minutos = (long) Math.ceil((double) request.duracaoSegundos() / 60.0);
        BigDecimal valorTotal = request.valorPorMinuto().multiply(BigDecimal.valueOf(minutos));

        var response = new BilheteResponse(
                UUID.randomUUID().toString(),
                request.idChamada(),
                valorTotal,
                LocalDateTime.now(),
                "PROCESSADO");

        return ResponseEntity.ok(response);
    }
}
