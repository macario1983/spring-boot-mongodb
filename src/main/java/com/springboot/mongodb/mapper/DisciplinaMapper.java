package com.springboot.mongodb.mapper;

import com.springboot.mongodb.dto.DisciplinaDTO;
import com.springboot.mongodb.model.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DisciplinaMapper {

    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "dataInsercao", ignore = true)
    Disciplina dtoToModel(DisciplinaDTO disciplinaDTO);

    DisciplinaDTO modelToDTO(Disciplina disciplina);

    List<DisciplinaDTO> modelsToDTOs(List<Disciplina> disciplinas);

}
