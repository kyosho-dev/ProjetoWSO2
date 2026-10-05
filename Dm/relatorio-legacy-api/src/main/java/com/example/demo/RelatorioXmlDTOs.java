package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class RelatorioXmlDTOs {
    @JacksonXmlRootElement(localName = "RelatorioConsolidado")
public record RelatorioConsolidadoXml(
    @JacksonXmlProperty(localName = "Header") HeaderXml header,
    @JacksonXmlProperty(localName = "ListaRegistros") ListaRegistrosXml registros
) {}

public record HeaderXml(
    @JacksonXmlProperty(localName = "Empresa") String empresa,
    @JacksonXmlProperty(localName = "TotalRegistros") Integer totalRegistros,
    @JacksonXmlProperty(localName = "DataGeracao") String dataGeracao
) {}

public record ListaRegistrosXml(
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Registro") List<RegistroItemXml> itens
) {}

public record RegistroItemXml(
    @JacksonXmlProperty(localName = "Id") String id,
    @JacksonXmlProperty(localName = "PlacaVeiculo") String placa,
    @JacksonXmlProperty(localName = "Quilometrajem") Double km,
    @JacksonXmlProperty(localName = "StatusFrota") String status,
    @JacksonXmlProperty(localName = "UltimaManutencao") String ultimaManutencao
) {}
}
