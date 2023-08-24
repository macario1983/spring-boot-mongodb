package com.springboot.mongodb.service;


import com.springboot.mongodb.dto.TipoAtividadeDTO;
import com.springboot.mongodb.mapper.TipoAtividadeMapper;
import com.springboot.mongodb.repository.TipoAtividadeRepository;
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
public class TipoAtividadeService {

    private final TipoAtividadeMapper tipoAtividadeMapper;
    private final TipoAtividadeRepository tipoAtividadeRepository;

    @Transactional(readOnly = true)
    public List<TipoAtividadeDTO> findAll() {
        return tipoAtividadeMapper.modelsToDTOs(tipoAtividadeRepository.findAll());
    }

    @Transactional(readOnly = true)
    public TipoAtividadeDTO findById(UUID id) {
        return tipoAtividadeMapper.modelToDTO(tipoAtividadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado")));
    }

    public TipoAtividadeDTO insert(TipoAtividadeDTO tipoAtividadeDTO) {
        return tipoAtividadeMapper.modelToDTO(tipoAtividadeRepository.save(tipoAtividadeMapper.dtoToModel(tipoAtividadeDTO)));
    }

    public TipoAtividadeDTO update(UUID id, TipoAtividadeDTO tipoAtividadeDTO) {
        tipoAtividadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        return tipoAtividadeMapper.modelToDTO(tipoAtividadeRepository.save(tipoAtividadeMapper.dtoToModel(tipoAtividadeDTO)));
    }

    public void delete(UUID id) {
        tipoAtividadeRepository.deleteById(id);
    }

}
