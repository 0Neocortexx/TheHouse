package com.thehouse.dto.meta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class MetaDTO {

    private Long id;
    @NotBlank(message = "Nome da metá é obrigatório!")
    private String nomeMeta;
    @Future(message = "A meta precisa ser uma hora futura")
    private LocalDate dataMeta;
    @PositiveOrZero(message = "O valor atual precisa ser 0 ou positivo")
    private Double valorAtual;
    @PositiveOrZero(message = "O valor total precisa ser 0 ou positivo")
    private Double valorTotal;
    private Boolean status;

    public MetaDTO() {
    }

    public MetaDTO(Long id, String nomeMeta, LocalDate dataMeta, Double valorAtual, Double valorTotal, Boolean status) {
        this.id = id;
        this.nomeMeta = nomeMeta;
        this.status = status;
        this.dataMeta = dataMeta;
        this.valorAtual = valorAtual;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }
    public String getNomeMeta() {
        return nomeMeta;
    }

    public LocalDate getDataMeta() {
        return dataMeta;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public void setDataMeta(LocalDate dataMeta) {
        this.dataMeta = dataMeta;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
