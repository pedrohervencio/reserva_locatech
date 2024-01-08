package br.com.locacar.api.reserva_locatech.entities;

import br.com.locacar.api.reserva_locatech.valueobject.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tb_reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private LocalDate dataRetirada;
    private Integer qtdeDiarias;
    private Integer vlrDiaria;
    @ManyToOne
    @JoinColumn(name = "atendente_numero")
    private Atendente atendente;
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id")
    private Veiculo veiculo;

    public Reserva() {}

    public Reserva(Long numero, LocalDate dataRetirada, Integer qtdeDiarias, Integer vlrDiaria, Atendente atendente, Cliente cliente, Veiculo veiculo) {
        this.numero = numero;
        this.dataRetirada = dataRetirada;
        this.qtdeDiarias = qtdeDiarias;
        this.vlrDiaria = vlrDiaria;
        this.atendente = atendente;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Integer getQtdeDiarias() {
        return qtdeDiarias;
    }

    public void setQtdeDiarias(Integer qtdeDiarias) {
        this.qtdeDiarias = qtdeDiarias;
    }

    public Integer getVlrDiaria() {
        return vlrDiaria;
    }

    public void setVlrDiaria(Integer vlrDiaria) {
        this.vlrDiaria = vlrDiaria;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(numero, reserva.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numero=" + numero +
                ", dataRetirada=" + dataRetirada +
                ", qtdeDiarias=" + qtdeDiarias +
                ", vlrDiaria=" + vlrDiaria +
                '}';
    }
}
