package com.thehouse.model.entities;

import jakarta.persistence.*;

@Entity
public class ListaDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private Integer quantidade;
    private Double precoUnitario;
    private Boolean possuiNoEstoque;

    public ListaDeCompra() {
    }
    public ListaDeCompra(Long id, String produto, Integer quantidade, Boolean possuiNoEstoque, Double precoUnitario) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.possuiNoEstoque = possuiNoEstoque;
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

    public Double valorFinal(Integer quantidade, Double precoUnitario) {
        return quantidade * precoUnitario;
    }
}
