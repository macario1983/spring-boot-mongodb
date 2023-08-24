package com.springboot.mongodb.service;

import com.springboot.mongodb.dto.DisciplinaSerieDTO;
import com.springboot.mongodb.mapper.DisciplinaSerieMapper;
import com.springboot.mongodb.repository.DisciplinaSerieRepository;
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
public class DisciplinaSerieService {

    private final DisciplinaSerieMapper disciplinaSerieMapper;
    private final DisciplinaSerieRepository disciplinaSerieRepository;

    @Transactional(readOnly = true)
    public List<DisciplinaSerieDTO> findAll() {
        return disciplinaSerieMapper.modelsToDTOs(disciplinaSerieRepository.findAll());
    }

    @Transactional(readOnly = true)
    public DisciplinaSerieDTO findById(UUID id) {
        return disciplinaSerieMapper.modelToDTO(disciplinaSerieRepository.findById(id).orElse(null));
    }

    public DisciplinaSerieDTO insert(DisciplinaSerieDTO disciplinaSerieDTO) {
        return disciplinaSerieMapper.modelToDTO(disciplinaSerieRepository.save(disciplinaSerieMapper.dtoToModel(disciplinaSerieDTO)));
    }

}
