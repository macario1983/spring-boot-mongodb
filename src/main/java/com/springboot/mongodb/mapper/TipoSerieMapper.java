package com.springboot.mongodb.mapper;

import com.springboot.mongodb.dto.TipoSerieDTO;
import com.springboot.mongodb.model.TipoSerie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TipoSerieMapper {

    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "dataInsercao", ignore = true)
    TipoSerie dtoToModel(TipoSerieDTO tipoSerieDTO);

    TipoSerieDTO modelToDTO(TipoSerie tipoSerie);

    List<TipoSerieDTO> modelsToDTOs(List<TipoSerie> tiposSerie);

}

