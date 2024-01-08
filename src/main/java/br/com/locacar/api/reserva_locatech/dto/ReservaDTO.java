package br.com.locacar.api.reserva_locatech.dto;

import br.com.locacar.api.reserva_locatech.entities.Atendente;
import br.com.locacar.api.reserva_locatech.entities.Veiculo;
import br.com.locacar.api.reserva_locatech.valueobject.Cliente;

import java.time.LocalDate;

public record ReservaDTO(
        Long numero,
        LocalDate dataRetirada,
        Integer qtdeDiarias,
        Integer vlrDiaria,
        Atendente atendente,
        Cliente cliente,
        Veiculo veiculo

) {
}
