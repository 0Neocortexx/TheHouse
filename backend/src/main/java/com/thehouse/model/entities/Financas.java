package com.thehouse.model.entities;

import com.thehouse.model.enums.FinanceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Financas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motivo;
    private Double valor;
    private FinanceType financeType;

    public Financas() {
    }

    public Financas(Long id, String motivo, Double valor, FinanceType financeType) {
        this.id = id;
        this.motivo = motivo;
        this.valor = valor;
        this.financeType = financeType;
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

    public FinanceType getFinanceType() {
        return financeType;
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

    public void setFinanceType(FinanceType valuesType) {
        this.financeType = valuesType;
    }

    public String toString(){
        return "id: " +  getId() + "\nmotivo: "+ getMotivo() + "\nvalor: " + getValor() + "\nreceita/despesa: "+ getFinanceType();
    }
}