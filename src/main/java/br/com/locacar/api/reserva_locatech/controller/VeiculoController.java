package br.com.locacar.api.reserva_locatech.controller;

import br.com.locacar.api.reserva_locatech.dto.VeiculoDTO;
import br.com.locacar.api.reserva_locatech.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva/veiculo")
public class VeiculoController {
    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "id")Pageable pageable
            ) {
        Page<VeiculoDTO> veiculoDTO = veiculoService.findAll(pageable);
        return ResponseEntity.ok(veiculoDTO);
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO savedVeiculo = veiculoService.save(veiculoDTO);
        return new ResponseEntity<>(savedVeiculo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
