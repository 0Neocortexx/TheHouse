package com.thehouse.controller;

import com.thehouse.dto.financa.FinancaDTO;
import com.thehouse.dto.message.ErrorMessage;
import com.thehouse.dto.message.SucessMessage;
import com.thehouse.service.FinancaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financa")
@CrossOrigin("*")
public class FinancaController {

    @Autowired
    private FinancaService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    // Rota para inserir uma nova finança
    @PostMapping("/novo")
    public ResponseEntity<?> addFinance(@RequestBody @Valid  FinancaDTO financaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarFinanca(financaDTO));
    }

    // Rota para inserir mais de uma nova finança
    @PostMapping("/novos")
    public ResponseEntity<?> addFinanceList(@RequestBody @Valid List<FinancaDTO> financaDTOList) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.inserirVarios(financaDTOList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Finança não encontrada!"));
        }
        return ResponseEntity.ok().body(service.buscarPorId(id));
     }

     @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirFinanca(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Finança não encontrada!"));
        }
        service.deleteFinance(service.buscarPorId(id));
        return ResponseEntity.status(HttpStatus.OK).body(new SucessMessage("Finança deletada com sucesso!"));
     }

     @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFinanca(@PathVariable Long id, @RequestBody @Valid FinancaDTO financaDTO) {
        if (service.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Finança não encontrada!"));
        }
        financaDTO.setId(id);
        return ResponseEntity.ok().body(service.alterarFinanca(id, financaDTO));
     }

    @DeleteMapping("/limpar")
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SucessMessage("TODAS A METAS FORAM DELETADAS"));
    }
}