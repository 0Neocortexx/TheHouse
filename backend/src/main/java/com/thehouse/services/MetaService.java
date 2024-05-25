package com.thehouse.services;

import com.thehouse.model.entities.ItemMeta;
import com.thehouse.repository.ItemMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private  ItemMetaRepository repository;

    public MetaService(ItemMetaRepository repository) {
        this.repository = repository;
    }

    public void salvar(ItemMeta itemMeta) {
        repository.save(itemMeta);
    }

    public List<ItemMeta> buscarTodos() {
        return repository.findAll();
    }


    public Optional<ItemMeta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void removerMeta(ItemMeta itemMeta) {
        repository.delete(itemMeta);
    }
}
