package com.springboot.mongodb.mapper;


import com.springboot.mongodb.dto.AlunoDisciplinaNotaDTO;
import com.springboot.mongodb.model.AlunoDisciplinaNota;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlunoDisciplinaNotaMapper {

    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "dataInsercao", ignore = true)
    AlunoDisciplinaNota dtoToModel(AlunoDisciplinaNotaDTO alunoDisciplinaNotaDTO);

    AlunoDisciplinaNotaDTO modelToDTO(AlunoDisciplinaNota alunoDisciplinaNota);

    List<AlunoDisciplinaNotaDTO> modelsToDTOs(List<AlunoDisciplinaNota> alunosDisciplinaNota);

}
