package com.springboot.mongodb.controller;


import com.springboot.mongodb.dto.TipoAtividadeDTO;
import com.springboot.mongodb.service.TipoAtividadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/tiposAtividade")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TipoAtividadeController {

    private final TipoAtividadeService tipoAtividadeService;

    @GetMapping
    public ResponseEntity<List<TipoAtividadeDTO>> findAll() {
        return ResponseEntity.ok().body(tipoAtividadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAtividadeDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(tipoAtividadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoAtividadeDTO> save(@RequestBody @Valid TipoAtividadeDTO tipoAtividadeDTO) {
        return ResponseEntity.ok().body(tipoAtividadeService.insert(tipoAtividadeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoAtividadeDTO> update(@PathVariable UUID id, @RequestBody @Valid TipoAtividadeDTO tipoAtividadeDTO) {
        return ResponseEntity.ok().body(tipoAtividadeService.update(id, tipoAtividadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tipoAtividadeService.delete(id);
        return ResponseEntity.ok().build();
    }

}
