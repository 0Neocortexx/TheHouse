package com.thehouse.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ListaDeFilmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoFilme;
    private LocalDate dataAssistida;

    public ListaDeFilmes() {
    }

    public ListaDeFilmes(Long id, String nomeDoFilme, LocalDate dataAssistida) {
        this.id = id;
        this.nomeDoFilme = nomeDoFilme;
        this.dataAssistida = dataAssistida;
    }

    public Long getId() {
        return id;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public LocalDate getDataAssistida() {
        return dataAssistida;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    public void setDataAssistida(LocalDate dataAssistida) {
        this.dataAssistida = dataAssistida;
    }
}

