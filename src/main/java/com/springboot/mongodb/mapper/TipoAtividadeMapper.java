package com.springboot.mongodb.mapper;

import com.springboot.mongodb.dto.TipoAtividadeDTO;
import com.springboot.mongodb.model.TipoAtividade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TipoAtividadeMapper {

    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "dataInsercao", ignore = true)
    TipoAtividade dtoToModel(TipoAtividadeDTO tipoAtividadeDTO);

    TipoAtividadeDTO modelToDTO(TipoAtividade tipoAtividade);

    List<TipoAtividadeDTO> modelsToDTOs(List<TipoAtividade> tiposAtividade);

}
