package com.thehouse.dto.compras;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;
public class ListaDeComprasDTO {
    private Long id;
    @NotBlank(message = "O produto não deve ser nulo nem vazio.")
    private String produto;

    @Positive(message = "A quantidade de produtos deve ser positiva")
    private Integer quantidade;

    @Positive(message = "O preço unitário deve ser positivo")
    private Double precoUnitario;
    private Boolean possuiNoEstoque;

    public ListaDeComprasDTO(Long id, String produto, Integer quantidade, Double precoUnitario, Boolean possuiNoEstoque) {
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
