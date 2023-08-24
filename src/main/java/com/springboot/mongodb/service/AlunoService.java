package com.springboot.mongodb.service;


import com.springboot.mongodb.dto.AlunoDTO;
import com.springboot.mongodb.mapper.AlunoMapper;
import com.springboot.mongodb.repository.AlunoRepository;
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
public class AlunoService {

    private final AlunoMapper alunoMapper;
    private final AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public List<AlunoDTO> findAll() {
        return alunoMapper.modelsToDTOs(alunoRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AlunoDTO findById(UUID id) {
        return alunoMapper.modelToDTO(alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public AlunoDTO insert(AlunoDTO alunoDTO) {
        return alunoMapper.modelToDTO(alunoRepository.save(alunoMapper.dtoToModel(alunoDTO)));
    }

    public AlunoDTO update(UUID id, AlunoDTO alunoDTO) {
        alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        return alunoMapper.modelToDTO(alunoRepository.save(alunoMapper.dtoToModel(alunoDTO)));
    }

    public void delete(UUID id) {
        alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        alunoRepository.deleteById(id);
    }
}
