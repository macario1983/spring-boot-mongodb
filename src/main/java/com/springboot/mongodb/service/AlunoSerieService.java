package com.springboot.mongodb.service;

import com.springboot.mongodb.dto.AlunoSerieDTO;
import com.springboot.mongodb.mapper.AlunoSerieMapper;
import com.springboot.mongodb.repository.AlunoSerieRepository;
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
public class AlunoSerieService {

    private final AlunoSerieMapper alunoSerieMapper;
    private final AlunoSerieRepository alunoSerieRepository;

    @Transactional(readOnly = true)
    public List<AlunoSerieDTO> findAll() {
        return alunoSerieMapper.modelsToDTOs(alunoSerieRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AlunoSerieDTO findById(UUID id) {
        return alunoSerieMapper.modelToDTO(alunoSerieRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public AlunoSerieDTO insert(AlunoSerieDTO alunoSerieDTO) {
        return alunoSerieMapper.modelToDTO(alunoSerieRepository.save(alunoSerieMapper.dtoToModel(alunoSerieDTO)));
    }

}

