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
        Meta meta = new Meta();
        meta.setNomeMeta(metaDTO.getNomeMeta());
        meta.setDataMeta(metaDTO.getDataMeta());
        meta.setValorTotal(metaDTO.getValorTotal());
        meta.setValorAtual(metaDTO.getValorAtual());
        meta.setStatus(metaDTO.getStatus());
        return meta;
    }

    public MetaDTO toDTO(Meta meta) {
        if (meta == null) {
            return null;
        }
        MetaDTO metaDTO = new MetaDTO();

        metaDTO.setId(meta.getId());
        metaDTO.setNomeMeta(meta.getNomeMeta());
        metaDTO.setDataMeta(meta.getDataMeta());
        metaDTO.setValorTotal(meta.getValorTotal());
        metaDTO.setValorAtual(meta.getValorAtual());
        metaDTO.setStatus(meta.getStatus());

        return metaDTO;
    }

}
