package com.thehouse.mapper;

import com.thehouse.dto.meta.MetaDTO;
import com.thehouse.model.entities.Meta;
import org.springframework.stereotype.Component;

@Component
public class MetaMapper {

    public MetaMapper() {
    }

    public Meta toEntity(MetaDTO metaDTO) {
        if (metaDTO == null) {
            return null;
        }
        return new Meta(metaDTO.getId(), metaDTO.getNomeMeta(), metaDTO.getDataMeta(), metaDTO.getValorAtual(), metaDTO.getValorTotal(), metaDTO.getStatus());
    }

    public MetaDTO toDTO(Meta meta) {
        if (meta == null) {
            return null;
        }
        return new MetaDTO(meta.getId(), meta.getNomeMeta(), meta.getDataMeta(), meta.getValorAtual(), meta.getValorTotal(), meta.getStatus());
    }

}
