package br.com.locacar.api.reserva_locatech.repository;

import br.com.locacar.api.reserva_locatech.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
