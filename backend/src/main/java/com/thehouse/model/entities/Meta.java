package com.thehouse.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity // Define que a classe será uma entidade do banco
public class Meta {

    @Id // Define que esse atributo será um ID
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Define que a estratégia adotada por esse valor será geração de identificador, não repetindo o numero (Serial)
    private Long id;
    private String nomeMeta;
    private LocalDate dataMeta;
    private Double valorAtual;
    private Double valorTotal;
    private Boolean status;

    public Meta() {
    }

    public  Meta(Long id, String nomeMeta, Boolean status, LocalDate dataMeta, Double valorAtual, Double valorTotal) {
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
    public Boolean getStatus() {
        return status;
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
    public void setId(Long id) {
        this.id = id;
    }
    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }
    public void setDataMeta(LocalDate dataMeta) {
        this.dataMeta = dataMeta;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String toString() {
        return "id: "+ getId() + "\nItem: " + getNomeMeta() + "\nStatus: " + getStatus() + "\nMeta: " + getDataMeta();
    }
}