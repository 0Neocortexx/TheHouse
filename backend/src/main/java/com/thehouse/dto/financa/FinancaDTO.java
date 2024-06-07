package com.thehouse.dto.financa;

import com.thehouse.model.enums.TipoFinanca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class FinancaDTO {
    private Long id;
    @NotBlank(message = "O motivo precisa ser informado")
    private String motivo;
    @PositiveOrZero(message = "O Valor deve ser um numero positivo ou zero")
    private Double valor;
    private TipoFinanca tipoFinanca;

    public FinancaDTO() {
    }
    public FinancaDTO(String motivo, Double valor, TipoFinanca tipoFinanca) {
        this.motivo = motivo;
        this.valor = valor;
        this.tipoFinanca = tipoFinanca;
    }

    public FinancaDTO(Long id, String motivo, Double valor, TipoFinanca tipoFinanca) {
        this.id = id;
        this.motivo = motivo;
        this.valor = valor;
        this.tipoFinanca = tipoFinanca;
    }

    public Long getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public Double getValor() {
        return valor;
    }

    public TipoFinanca getTipoFinanca() {
        return tipoFinanca;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setTipoFinanca(TipoFinanca tipoFinanca) {
        this.tipoFinanca = tipoFinanca;
    }
}
