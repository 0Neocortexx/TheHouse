package com.thehouse.service;

import com.thehouse.dto.financa.FinancaDTO;
import com.thehouse.mapper.FinancaMapper;
import com.thehouse.model.entities.Financa;
import com.thehouse.repository.FinancaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancaService {
    private final FinancaRepository repository;
    private final FinancaMapper mapper;

    public FinancaService(FinancaRepository repository, FinancaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<FinancaDTO> buscarTodos() {
       return repository.findAllByOrderByIdAsc().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    public FinancaDTO buscarPorId(Long id) {
        Financa financa = repository.findById(id).orElse(null);
        if (financa == null) {
            return null;
        }
        return mapper.toDTO(financa);
    }
    public FinancaDTO salvarFinanca(FinancaDTO financaDTO) {
        Financa financaSalva = mapper.toEntity(financaDTO);
        return mapper.toDTO(repository.save(financaSalva));
    }

    // Metodo que salva alterações de finança no banco
    // Reduzir o código
    public FinancaDTO alterarFinanca(Long id, FinancaDTO financaDTO) {
        Financa financaExistente = repository.findById(id).orElse(null);
        if (financaExistente == null) {
            return null;
        }
        financaExistente.setMotivo(financaDTO.getMotivo());
        financaExistente.setValor(financaDTO.getValor());
        financaExistente.setTipoFinanca(financaDTO.getTipoFinanca());
        repository.save(financaExistente);
        return mapper.toDTO(financaExistente);
    }

    // Método que deleta todas as informações do banco
    // Ajustar para manter um padrão de projeto
    public void deleteAll() {
        repository.deleteAll();
    }

    // Método que deleta uma finança do banco e retorna a mesma
    public void deleteFinance(FinancaDTO financaDTO) {
        repository.delete(mapper.toEntity(financaDTO));
    }

    // Método que salva vários elementos de uma lista no banco
    public List<FinancaDTO> inserirVarios (List<FinancaDTO> financasDTO) { // Retorna uma lista de finanças e recebe uma lista de finanças
        List<FinancaDTO> financasSalvas = new ArrayList<>(); // Cria o array para as finanças que serão salvas
        for (FinancaDTO financaDTO : financasDTO) { // realizar uma for para cada item na lista recebida
            Financa financa = mapper.toEntity(financaDTO); // Mapeia o item da lista
            financasSalvas.add(mapper.toDTO(repository.save(financa))); // salva o item no banco e adiciona no array de finanças salvas
        }
        return financasSalvas; // Retorna o array de finanças salvas
    }
}
