package com.thehouse.controller;

import com.thehouse.model.entities.ListaDeCompra;
import com.thehouse.repository.ListaDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin("*")
public class ListaDeCompraController {

    @Autowired
    private ListaDeCompraRepository listaDeCompraRepository;


    @GetMapping("/listacompras")
    public List<ListaDeCompra> getAll() {
        return listaDeCompraRepository.findAll();
    }

    @PostMapping("/novo")
    public String addFinance(@RequestBody ListaDeCompra listaDeCompra) {
        listaDeCompraRepository.save(listaDeCompra);
        return "Item da compra salvo!";
    }
}
