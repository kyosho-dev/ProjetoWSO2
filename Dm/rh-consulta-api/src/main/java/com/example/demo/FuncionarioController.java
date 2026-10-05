package com.example.demo;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FuncionarioDTO.FuncionarioResponse;

@RestController
@RequestMapping("/v2/funcionarios")
public class FuncionarioController {
    @GetMapping("/{matricula}")
    public ResponseEntity<FuncionarioResponse> buscarPorMatricula(@PathVariable String matricula) {
        // Simulação de busca
        var funcionario = new FuncionarioResponse(
            matricula,
            "Carlos Eduardo",
            "Engenheiro de Software Pleno",
            "Sistemas de Integração",
            new BigDecimal("7000.00"),
            true
        );

        return ResponseEntity.ok(funcionario);
    }
}
