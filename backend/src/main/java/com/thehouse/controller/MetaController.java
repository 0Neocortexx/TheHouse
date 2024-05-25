package com.thehouse.controller;

import com.thehouse.dto.ErrorMessage;
import com.thehouse.model.entities.ItemMeta;
import com.thehouse.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping("/metas")
    public List<ItemMeta> getAll() {
        return metaService.buscarTodos();
    }

    @PostMapping("/metas/novo")
    public String addMeta(@RequestBody ItemMeta itemMeta) {
        metaService.salvar(itemMeta);
        return "Meta cadastrada!";
    }

    @PutMapping("/metas/alterar")
    public String alterarMeta(@RequestBody ItemMeta itemMeta) {
        metaService.salvar(itemMeta);
        return "Alterado!";
    }

    /*
    * ResponseEntity<?> Representa uma resposta HTTP de um controlador de Spring MVC ou de um endpoint REST
    * ResponseEntity<?> significa que a resposta pode ser qualquer tipo de objeto.
    */
    // Método para realizar busca por id
    @GetMapping("/meta/{id}") // A rota para realizar uma busca por ID (vai receber um id através da rota)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        if(metaService.buscarPorId(id).isEmpty()) { // Se a busca por id der null ou vazio
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Meta não encontrada!")); // Responderá com um Page not found e enviará a mensagem
        } else { // Se encontrar a mensagem
            return ResponseEntity.ok(metaService.buscarPorId(id)); // Retornará o objeto
        }
    }

}