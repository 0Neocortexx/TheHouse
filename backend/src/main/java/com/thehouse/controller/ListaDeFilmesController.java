package com.thehouse.controller;

import com.thehouse.model.entities.ListaDeCompra;
import com.thehouse.model.entities.ListaDeFilmes;
import com.thehouse.repository.ListaDeFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entretenimento")
public class ListaDeFilmesController {

    @Autowired
    private ListaDeFilmeRepository listaDeFilmeRepository;

    @GetMapping("/filmes/listafilmes")
    public List<ListaDeFilmes> getAll() {
        return listaDeFilmeRepository.findAll();
    }

    // Verificar formato do json enviado para o backend
    @PostMapping("/filmes/novo")
    public String addFilme(@RequestBody ListaDeFilmes listaDeFilmes) {
        listaDeFilmeRepository.save(listaDeFilmes);
        return "Filme cadastrado!";
    }

}
