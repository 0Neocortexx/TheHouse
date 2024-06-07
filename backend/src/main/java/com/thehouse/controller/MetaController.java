package com.thehouse.controller;

import com.thehouse.dto.message.ErrorMessage;
import com.thehouse.dto.message.SucessMessage;
import com.thehouse.dto.meta.MetaDTO;
import com.thehouse.service.MetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meta")
@CrossOrigin("*")
public class MetaController {

    @Autowired
    private MetaService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        List<MetaDTO> lista = service.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> addMeta(@RequestBody @Valid MetaDTO metaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(metaDTO));
    }

    /*
    * O método alterarMeta recebe o id informado na rota e o corpo da requisição
    * Caso não encontre o id informado na rota da requisição retornará 404 e enviará uma mensagem
    * Caso encontre, usará o id informado na rota e o objeto recebido no corpo para realizar a alteração
    */
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMeta(@PathVariable Long id, @RequestBody @Valid MetaDTO metaDTO) {
        MetaDTO metaAtualizada = service.atualizarMeta(id, metaDTO);
        if (metaAtualizada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("META NÃO ENCONTRADA"));
        }
        metaDTO.setId(id);
        return ResponseEntity.ok().body(metaAtualizada);
    }

    /*
    * ResponseEntity<?> Representa uma resposta HTTP de um controlador de Spring MVC ou de um endpoint REST
    * ResponseEntity<?> significa que a resposta pode ser qualquer tipo de objeto.
    */
    // Método para realizar busca por id
    @GetMapping("/{id}") // A rota para realizar uma busca por ID (vai receber um id através da rota)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        MetaDTO metaDTO = service.buscarPorId(id);
        if(metaDTO == null) { // Se a busca por id der null ou vazio
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Meta não encontrada!")); // Responderá com um Page not found e enviará a mensagem
        } else {
            return ResponseEntity.ok(metaDTO); // Retornará o objeto
        }
    }

    //

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> removerMeta(@PathVariable Long id) {
        MetaDTO metaDTO = service.buscarPorId(id);
        if (metaDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("META NÃO ENCONTRADA"));
        } else {
            service.removerMeta(metaDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new SucessMessage("Meta Removida com sucesso!"));
        }
    }


    @DeleteMapping("/limpar")
    public ResponseEntity<?> deleteAll() {
        service.removerTodas();
        return ResponseEntity.status(HttpStatus.OK).body(new SucessMessage("TODAS A METAS FORAM DELETADAS"));
    }


}