package com.springboot.mongodb.service;

import com.springboot.mongodb.dto.SerieDTO;
import com.springboot.mongodb.mapper.SerieMapper;
import com.springboot.mongodb.repository.SerieRepository;
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
public class SerieService {

    private final SerieMapper serieMapper;
    private final SerieRepository serieRepository;

    @Transactional(readOnly = true)
    public List<SerieDTO> findAll() {
        return serieMapper.modelsToDTOs(serieRepository.findAll());
    }

    @Transactional(readOnly = true)
    public SerieDTO findById(UUID id) {
        return serieMapper.modelToDTO(serieRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public SerieDTO insert(SerieDTO serieDTO) {
        return serieMapper.modelToDTO(serieRepository.save(serieMapper.dtoToModel(serieDTO)));
    }

    public SerieDTO update(UUID id, SerieDTO serieDTO) {
        serieRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        return serieMapper.modelToDTO(serieRepository.save(serieMapper.dtoToModel(serieDTO)));
    }

    public void delete(UUID id) {
        serieRepository.deleteById(id);
    }

}
