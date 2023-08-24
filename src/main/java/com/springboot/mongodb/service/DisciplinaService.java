package com.springboot.mongodb.service;

import com.springboot.mongodb.dto.DisciplinaDTO;
import com.springboot.mongodb.mapper.DisciplinaMapper;
import com.springboot.mongodb.repository.DisciplinaRepository;
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
public class DisciplinaService {

    private final DisciplinaMapper disciplinaMapper;
    private final DisciplinaRepository disciplinaRepository;

    @Transactional(readOnly = true)
    public List<DisciplinaDTO> findAll() {
        return disciplinaMapper.modelsToDTOs(disciplinaRepository.findAll());
    }

    @Transactional(readOnly = true)
    public DisciplinaDTO findById(UUID id) {
        return disciplinaMapper.modelToDTO(disciplinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public DisciplinaDTO insert(DisciplinaDTO disciplinaDTO) {
        return disciplinaMapper.modelToDTO(disciplinaRepository.save(disciplinaMapper.dtoToModel(disciplinaDTO)));
    }

    public DisciplinaDTO update(UUID id, DisciplinaDTO disciplinaDTO) {
        disciplinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        return disciplinaMapper.modelToDTO(disciplinaRepository.save(disciplinaMapper.dtoToModel(disciplinaDTO)));
    }

    public void delete(UUID id) {
        disciplinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        disciplinaRepository.deleteById(id);
    }
}
