package com.thehouse.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.thehouse.model.entities.ItemMeta;
import com.thehouse.repository.ItemMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    @Autowired
    private ItemMetaRepository itemMetaRepository;

    @GetMapping("/listametas")
    public List<ItemMeta> getAll() {
        return itemMetaRepository.findAll();
    }

    @PostMapping("/novo")
    public String addMeta(@RequestBody ItemMeta itemMeta) {
        itemMetaRepository.save(itemMeta);
        return "Meta cadastrada!";
    }
}