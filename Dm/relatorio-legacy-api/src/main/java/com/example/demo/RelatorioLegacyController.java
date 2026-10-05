package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RelatorioXmlDTOs.HeaderXml;
import com.example.demo.RelatorioXmlDTOs.ListaRegistrosXml;
import com.example.demo.RelatorioXmlDTOs.RegistroItemXml;
import com.example.demo.RelatorioXmlDTOs.RelatorioConsolidadoXml;

@RestController
@RequestMapping("/v3/relatorios")
public class RelatorioLegacyController {
    @GetMapping(value = "/frota/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RelatorioConsolidadoXml> gerarRelatorioXMLGrande(
            @RequestParam(defaultValue = "500") int quantidade) {

        List<RegistroItemXml> itens = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            itens.add(new RegistroItemXml(
                "REG-" + UUID.randomUUID().toString().substring(0, 8),
                "ABC-" + (1000 + i),
                15000.0 + (i * 12.5),
                (i % 2 == 0) ? "EM_TRANSITO" : "DISPONIVEL",
                "2026-09-15T10:30:00"
            ));
        }

        var header = new HeaderXml("Logística & Transportes S.A.", itens.size(), LocalDateTime.now().toString());
        var payload = new RelatorioConsolidadoXml(header, new ListaRegistrosXml(itens));

        return ResponseEntity.ok(payload);
    }
}
