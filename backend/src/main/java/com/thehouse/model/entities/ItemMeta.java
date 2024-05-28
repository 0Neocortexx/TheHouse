package com.thehouse.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity // Define que a classe será uma entidade do banco
public class ItemMeta {

    @Id // Define que esse atributo será um ID
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Define que a estratégia adotada por esse valor será geração de identificador, não repetindo o numero (Serial)
    private Long id;
    private String item;
    private Boolean status;
    private LocalDate meta;
    private Double valorAtual;
    private Double valorTotal;

    public ItemMeta () {
    }

    public  ItemMeta(Long id, String item, Boolean status, LocalDate meta, Double valorAtual, Double valorTotal) {
        this.id = id;
        this.item = item;
        this.status = status;
        this.meta = meta;
        this.valorAtual = valorAtual;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDate getMeta() {
        return meta;
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

    public void setItem(String item) {
        this.item = item;
    }

    public void setMeta(LocalDate meta) {
        this.meta = meta;
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
        return "id: "+ getId() + "\nItem: " + getItem() + "\nStatus: " + getStatus() + "\nMeta: " + getMeta();
    }
}