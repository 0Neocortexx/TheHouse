package com.thehouse.model.entities;

import com.thehouse.model.enums.TipoFinanca;
import jakarta.persistence.*;

@Entity
public class Financa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo;
    private Double valor;
    private TipoFinanca tipoFinanca;

    public Financa() { 
    }

    public Financa(String motivo, Double valor, TipoFinanca tipoFinanca) {
        this.motivo = motivo;
        this.valor = valor;
        this.tipoFinanca = tipoFinanca;
    }

    public Financa(Long id, String motivo, Double valor, TipoFinanca tipoFinanca) {
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