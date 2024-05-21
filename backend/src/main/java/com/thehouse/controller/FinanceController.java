package com.thehouse.controller;

import com.thehouse.model.entities.Financas;
import com.thehouse.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeiro")
public class FinanceController {

    @Autowired
    private FinanceRepository financeRepository;

    @GetMapping("/verfinancas")
    public List<Financas> getAll() {
        return financeRepository.findAll();
    }

    @PostMapping("/novo")
    public String addFinance(@RequestBody Financas financas) {
        financeRepository.save(financas);
        return "Finança salva!";
    }
}