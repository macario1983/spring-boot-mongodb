package com.springboot.mongodb.mapper;

import com.springboot.mongodb.dto.AlunoDTO;
import com.springboot.mongodb.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlunoMapper {

    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "dataInsercao", ignore = true)
    Aluno dtoToModel(AlunoDTO alunoDTO);

    AlunoDTO modelToDTO(Aluno aluno);

    List<AlunoDTO> modelsToDTOs(List<Aluno> alunos);

}
