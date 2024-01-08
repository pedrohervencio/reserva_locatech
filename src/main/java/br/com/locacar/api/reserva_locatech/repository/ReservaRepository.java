package br.com.locacar.api.reserva_locatech.repository;

import br.com.locacar.api.reserva_locatech.dto.ReservaDTO;
import br.com.locacar.api.reserva_locatech.entities.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findByDataRetirada(Pageable pageable, LocalDate dataRetirada);
}
