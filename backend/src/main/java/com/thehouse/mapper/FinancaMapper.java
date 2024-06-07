package com.thehouse.mapper;

import com.thehouse.dto.financa.FinancaDTO;
import com.thehouse.model.entities.Financa;
import org.springframework.stereotype.Component;

@Component
public class FinancaMapper {
    public Financa toEntity(FinancaDTO financaDTO){
        return new Financa(financaDTO.getId(), financaDTO.getMotivo(), financaDTO.getValor(), financaDTO.getTipoFinanca());
    }

    // Formato reduzido (Implementar nos próximos)
    public FinancaDTO toDTO(Financa financa) {
        return new FinancaDTO(financa.getId(), financa.getMotivo(), financa.getValor(), financa.getTipoFinanca());
    }
}
