package com.thehouse.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListaDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private Integer quantidade;
    private Double precoUnitario;
    private Boolean possuiNoEstoque;
    private Double valorFinal;

    public ListaDeCompra() {
    }
    public ListaDeCompra(Long id, String produto, Integer quantidade, Boolean possuiNoEstoque, Double precoUnitario, Double valorFinal) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.possuiNoEstoque = possuiNoEstoque;
        this.valorFinal = valorFinal;
    }

    public Long getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public Boolean getPossuiNoEstoque() {
        return possuiNoEstoque;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setPossuiNoEstoque(Boolean possuiNoEstoque) {
        this.possuiNoEstoque = possuiNoEstoque;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return getId() + " - " + getProduto() + " - " + getQuantidade() + " - " + getPrecoUnitario()+ " - " + getPossuiNoEstoque() + " - " + getValorFinal();
    }
}
