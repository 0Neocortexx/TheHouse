package com.thehouse.controller;

import com.thehouse.dto.ErrorMessage;
import com.thehouse.dto.SucessMessage;
import com.thehouse.model.entities.ItemMeta;
import com.thehouse.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping("/metas")
    public List<ItemMeta> getAll() {
        return metaService.buscarTodos();
    }

    @PostMapping("/meta/novo")
    public ResponseEntity<?> addMeta(@RequestBody ItemMeta itemMeta) {
        metaService.salvar(itemMeta);
        return ResponseEntity.status(HttpStatus.OK).body(new SucessMessage("NOVA META CADASTRADA!"));
    }

    /*
    * O método alterarMeta recebe o id informado na rota e o corpo da requisição
    * Caso não encontre o id informado na rota da requisição retornará 404 e enviará uma mensagem
    * Caso encontre, usará o id informado na rota e o objeto recebido no corpo para realizar a alteração
    */
    @PutMapping("/meta/alterar/{id}")
    public ResponseEntity<?> alterarMeta(@PathVariable Long id, @RequestBody ItemMeta itemMeta) {
        if (metaService.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("META NÃO ENCONTRADA"));
        } else {
            itemMeta.setId(id);
            metaService.salvar(itemMeta);
            return ResponseEntity.status(HttpStatus.OK).body(itemMeta);
        }
    }

    /*
    * ResponseEntity<?> Representa uma resposta HTTP de um controlador de Spring MVC ou de um endpoint REST
    * ResponseEntity<?> significa que a resposta pode ser qualquer tipo de objeto.
    */
    // Método para realizar busca por id
    @GetMapping("/meta/{id}") // A rota para realizar uma busca por ID (vai receber um id através da rota)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        if(metaService.buscarPorId(id) == null) { // Se a busca por id der null ou vazio
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Meta não encontrada!")); // Responderá com um Page not found e enviará a mensagem
        } else { // Se encontrar a mensagem
            return ResponseEntity.ok(metaService.buscarPorId(id)); // Retornará o objeto
        }
    }

    @DeleteMapping("/meta/excluir/{id}")
    public ResponseEntity<?> removerMeta(@PathVariable Long id) {
        ItemMeta item = metaService.buscarPorId(id);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("META NÃO ENCONTRADA"));
        } else {
            metaService.removerMeta(item);
            return ResponseEntity.status(HttpStatus.OK).body(item);
        }
    }


    @DeleteMapping("/meta/excluir")
    public ResponseEntity<?> deleteAll() {
        metaService.removerTodas();
        return ResponseEntity.status(HttpStatus.OK).body(new SucessMessage("TODAS A METAS FORAM DELETADAS"));
    }


}