package com.thehouse.controller;

import com.thehouse.model.entities.Financas;
import com.thehouse.repository.FinanceRepository;
import com.thehouse.services.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class FinanceController {

    private FinanceService financeService;

    @GetMapping("/financas")
    public List<Financas> getAll() {
        return financeService.buscarTodos();
    }

    @PostMapping("/financas/novo")
    public String addFinance(@RequestBody Financas financas) {
        financeService.salvar(financas);
        return "Finança salva!";
    }
}