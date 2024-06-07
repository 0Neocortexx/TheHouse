package com.thehouse.service;

import com.thehouse.dto.financa.FinancaDTO;
import com.thehouse.mapper.FinancaMapper;
import com.thehouse.model.entities.Financa;
import com.thehouse.repository.FinancaRepository;
import org.springframework.stereotype.Service;

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

    public void deleteFinance(FinancaDTO financaDTO) {
        repository.delete(mapper.toEntity(financaDTO));
    }
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
    public void deleteAll() {
        repository.deleteAll();
    }
}
