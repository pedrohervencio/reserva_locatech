package br.com.locacar.api.reserva_locatech.service;

import br.com.locacar.api.reserva_locatech.dto.VeiculoDTO;
import br.com.locacar.api.reserva_locatech.entities.Veiculo;
import br.com.locacar.api.reserva_locatech.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Page<VeiculoDTO> findAll(Pageable pageable) {
        Page<Veiculo> veiculos = veiculoRepository.findAll(pageable);
        return veiculos.map(this::toDTO);
    }

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = toEntity(veiculoDTO);
        veiculo = veiculoRepository.save(veiculo);

        return toDTO(veiculo);
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
        return;
    }

    private VeiculoDTO toDTO(Veiculo veiculo) {

        return new VeiculoDTO(veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getCor(),
                veiculo.getAnoFabricacao(),
                veiculo.getAnoModelo(),
                veiculo.getCategoria()
                );
    }

    private Veiculo toEntity (VeiculoDTO veiculoDTO) {
        return new Veiculo(
                veiculoDTO.id(),
                veiculoDTO.placa(),
                veiculoDTO.marca(),
                veiculoDTO.modelo(),
                veiculoDTO.cor(),
                veiculoDTO.anoFabricacao(),
                veiculoDTO.anoModelo(),
                veiculoDTO.categoria()
        );
    }
}
