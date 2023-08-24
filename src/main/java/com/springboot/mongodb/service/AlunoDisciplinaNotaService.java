package com.springboot.mongodb.service;


import com.springboot.mongodb.dto.AlunoDisciplinaNotaDTO;
import com.springboot.mongodb.mapper.AlunoDisciplinaNotaMapper;
import com.springboot.mongodb.repository.AlunoDisciplinaNotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Lazy
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
@Transactional
public class AlunoDisciplinaNotaService {

    private final AlunoDisciplinaNotaMapper alunoDisciplinaNotaMapper;
    private final AlunoDisciplinaNotaRepository alunoDisciplinaNotaRepository;

    @Transactional(readOnly = true)
    public List<AlunoDisciplinaNotaDTO> findAll() {
        return alunoDisciplinaNotaMapper.modelsToDTOs(alunoDisciplinaNotaRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AlunoDisciplinaNotaDTO findById(UUID id) {
        return alunoDisciplinaNotaMapper.modelToDTO(alunoDisciplinaNotaRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public AlunoDisciplinaNotaDTO insert(AlunoDisciplinaNotaDTO alunoDisciplinaNotaDTO) {
        return alunoDisciplinaNotaMapper.modelToDTO(alunoDisciplinaNotaRepository.save(alunoDisciplinaNotaMapper.dtoToModel(alunoDisciplinaNotaDTO)));
    }
}
