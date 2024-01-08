package br.com.locacar.api.reserva_locatech.dto;

public record VeiculoDTO(
        Long id,
        String placa,
        String marca,
        String modelo,
        String cor,
        Integer anoFabricacao,
        Integer anoModelo,
        String categoria
) {
}
