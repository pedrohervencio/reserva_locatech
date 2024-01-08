package br.com.locacar.api.reserva_locatech.service;

import br.com.locacar.api.reserva_locatech.controller.exception.ControllerNotFoundException;
import br.com.locacar.api.reserva_locatech.dto.ReservaDTO;
import br.com.locacar.api.reserva_locatech.entities.Reserva;
import br.com.locacar.api.reserva_locatech.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Page<ReservaDTO> findAll(Pageable pageable) {
        Page<Reserva> reservas = reservaRepository.findAll(pageable);
        return reservas.map(this::toDTO);
    }

    public Page<ReservaDTO> findByDataRetirada(Pageable pageable, LocalDate dataRetirada) {
        Page<Reserva> reservas = reservaRepository.findByDataRetirada(pageable, dataRetirada);
        return reservas.map(this::toDTO);
    }

    public ReservaDTO findById(Long numero) {
        Reserva reserva = reservaRepository.findById(numero).
                orElseThrow(() -> new ControllerNotFoundException("Reserva não encontrada"));
        return toDTO(reserva);
    }

    public ReservaDTO save(ReservaDTO reservaDTO) {
        Reserva reserva = toEntity(reservaDTO);
        reserva = reservaRepository.save(reserva);
        return toDTO(reserva);
    }

    public ReservaDTO update(Long numero, ReservaDTO reservaDTO) {
        try {
            Reserva reserva = reservaRepository.getReferenceById(numero);
            reserva.setDataRetirada(reservaDTO.dataRetirada());
            reserva.setQtdeDiarias(reservaDTO.qtdeDiarias());
            reserva.setVlrDiaria(reservaDTO.vlrDiaria());
            reserva.setAtendente(reservaDTO.atendente());
            reserva.setCliente(reservaDTO.cliente());
            reserva.setVeiculo(reservaDTO.veiculo());
            reserva = reservaRepository.save((reserva));
            return toDTO(reserva);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Reserva nao encontrada");
        }
    }

    public void delete(Long numero) {
        reservaRepository.deleteById(numero);
        return;
    }

    private ReservaDTO toDTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getNumero(),
                reserva.getDataRetirada(),
                reserva.getQtdeDiarias(),
                reserva.getVlrDiaria(),
                reserva.getAtendente(),
                reserva.getCliente(),
                reserva.getVeiculo()
                );
    }
    private Reserva toEntity(ReservaDTO reservaDTO) {
        return new Reserva(
                reservaDTO.numero(),
                reservaDTO.dataRetirada(),
                reservaDTO.qtdeDiarias(),
                reservaDTO.vlrDiaria(),
                reservaDTO.atendente(),
                reservaDTO.cliente(),
                reservaDTO.veiculo()
        );
    }

}
