package com.thehouse.service;

import com.thehouse.model.entities.Financas;
import com.thehouse.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {
    @Autowired
    private FinanceRepository repository;

    public FinanceService(FinanceRepository repository) {
        this.repository = repository;
    }

    public List<Financas> buscarTodos() {
        return repository.findAllByOrderByIdAsc();
    }

    public Financas buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void salvar(Financas financas) {
        repository.save(financas);
    }

    public void deleteFinance(Financas financas) {
        repository.delete(financas);
    }

}
