package br.com.locacar.api.reserva_locatech.controller;

import br.com.locacar.api.reserva_locatech.dto.ReservaDTO;
import br.com.locacar.api.reserva_locatech.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<Page<ReservaDTO>> findAll(
            @PageableDefault(size= 10, page = 0, sort="numero")Pageable pageable
            ) {
        Page<ReservaDTO> reservasDTO = reservaService.findAll(pageable);
        return ResponseEntity.ok(reservasDTO);
    }
    @GetMapping("/dataRetirada {dataRetirada}")
    public ResponseEntity<Page<ReservaDTO>> findByDataRetirada(
            @PageableDefault(size= 10, page = 0, sort="numero")Pageable pageable,
            @PathVariable LocalDate dataRetirada
    ) {
        Page<ReservaDTO> reservasDTO = reservaService.findByDataRetirada(pageable, dataRetirada);
        return ResponseEntity.ok(reservasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        ReservaDTO reservaDTO = reservaService.findById(id);
        return ResponseEntity.ok(reservaDTO);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO savedReserva = reservaService.save(reservaDTO);
        return new ResponseEntity<>(savedReserva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
        ReservaDTO updatedReservaDTO = reservaService.update(id, reservaDTO);
        return ResponseEntity.ok(updatedReservaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();

    }
}





