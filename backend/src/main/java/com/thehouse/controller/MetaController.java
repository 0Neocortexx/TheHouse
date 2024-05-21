package com.thehouse.controller;

import com.thehouse.model.entities.ItemMeta;
import com.thehouse.repository.ItemMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private ItemMetaRepository itemMetaRepository;

    @GetMapping("/vermetas")
    public List<ItemMeta> getAll() {
        return itemMetaRepository.findAll();
    }

    @PostMapping("/novo")
    public String AddMeta(@RequestBody ItemMeta itemMeta) {
        itemMeta.setMeta(LocalDate.now());
        itemMetaRepository.save(itemMeta);
        return "Meta cadastrada!";
    }
}