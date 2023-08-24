package com.springboot.mongodb.service;


import com.springboot.mongodb.dto.TipoSerieDTO;
import com.springboot.mongodb.mapper.TipoSerieMapper;
import com.springboot.mongodb.repository.TipoSerieRepository;
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
public class TipoSerieService {

    private final TipoSerieMapper tipoSerieMapper;
    private final TipoSerieRepository tipoSerieRepository;

    @Transactional(readOnly = true)
    public List<TipoSerieDTO> findAll() {
        return tipoSerieMapper.modelsToDTOs(tipoSerieRepository.findAll());
    }

    @Transactional(readOnly = true)
    public TipoSerieDTO findById(UUID id) {
        return tipoSerieMapper.modelToDTO(tipoSerieRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public TipoSerieDTO insert(TipoSerieDTO tipoSerieDTO) {
        return tipoSerieMapper.modelToDTO(tipoSerieRepository.save(tipoSerieMapper.dtoToModel(tipoSerieDTO)));
    }

    public TipoSerieDTO update(UUID id, TipoSerieDTO tipoSerieDTO) {
        tipoSerieRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        return tipoSerieMapper.modelToDTO(tipoSerieRepository.save(tipoSerieMapper.dtoToModel(tipoSerieDTO)));
    }

    public void delete(UUID id) {
        tipoSerieRepository.deleteById(id);
    }

}
