package com.thehouse.service;

import com.thehouse.dto.meta.MetaDTO;
import com.thehouse.mapper.MetaMapper;
import com.thehouse.model.entities.Meta;
import com.thehouse.repository.MetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaService {

    private final MetaRepository repository;
    private final MetaMapper mapper;

    public MetaService(MetaRepository repository, MetaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MetaDTO salvar(MetaDTO metaDTO) {
        Meta meta = mapper.toEntity(metaDTO);
        Meta metaSalva = repository.save(meta);
        return mapper.toDTO(metaSalva);
    }
    public List<MetaDTO> buscarTodos() {
        List<Meta> lista = repository.findAllByOrderByIdAsc();
        return lista.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    public MetaDTO buscarPorId(Long id) {
        Meta meta = repository.findById(id).orElse(null);
        if (meta == null) {
            return null;
        }
        return mapper.toDTO(meta);
    }

    public MetaDTO atualizarMeta(Long id, MetaDTO metaDTO) {
        Meta metaExistente = repository.findById(id).orElse(null);

        if (metaExistente == null) {
            return null;
        }

        metaExistente.setNomeMeta(metaDTO.getNomeMeta());
        metaExistente.setDataMeta(metaDTO.getDataMeta());
        metaExistente.setValorTotal(metaDTO.getValorTotal());
        metaExistente.setValorAtual(metaDTO.getValorAtual());
        metaExistente.setStatus(metaDTO.getStatus());

        Meta metaAtualizada = repository.save(metaExistente);

        return mapper.toDTO(metaAtualizada);
    }

    public void removerMeta(MetaDTO metaDTO) {
        Meta meta = mapper.toEntity(metaDTO);
        repository.delete(meta);
    }

    public void removerTodas() {
        repository.deleteAll();
    }
}