package com.springboot.mongodb.mapper;

import com.springboot.mongodb.dto.AlunoSerieDTO;
import com.springboot.mongodb.model.AlunoSerie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlunoSerieMapper {

    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "dataInsercao", ignore = true)
    AlunoSerie dtoToModel(AlunoSerieDTO alunoSerieDTO);

    AlunoSerieDTO modelToDTO(AlunoSerie alunoSerie);

    List<AlunoSerieDTO> modelsToDTOs(List<AlunoSerie> alunosSerie);

}
